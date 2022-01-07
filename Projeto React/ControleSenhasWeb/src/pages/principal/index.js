import React, { useEffect, useState } from 'react';
import { Col, Input, Row, Form, Button, notification, Modal, Card, Layout, Typography, Image } from 'antd';
import api from '../../services/api';
import mensagemExcecao from '../../services/funcoes';
import { ExclamationCircleOutlined } from '@ant-design/icons';
import { Content, Header } from 'antd/lib/layout/layout';

export default function Principal() {
    const [contaGerente, setContaGerente] = useState(false);
    const [form] = Form.useForm();
    const [abrirModalGerencial, setAbrirModalGerencial] = useState(false);

    useEffect(() => {
        buscarSenhaAtual();
    }, []);

    function buscarSenhaAtual() {
        api.get("/SenhaChamada/Buscar").then(
            (res) => {
                let dados = res.data;
                if (!!dados) {
                    form.setFieldsValue({ senhaAtual: dados });
                }
            }
        ).catch(
            erro => {
                mensagemExcecao(erro);
            }
        )
    };

    function pegarSenhaNormal() {
        pegarSenha(false);
    };

    function pegarSenhaPreferencial() {
        pegarSenha(true);
    };

    function pegarSenha(preferencial) {
        api.post(`/Senha/IncluirSenha?preferencial=${preferencial}`).then(
            res => {
                let dados = res.data;
                notification.success({ description: `Senha retirada com sucesso, o numero da sua senha é ${dados.sen_senha}!`, message: "Sucesso" });
            }
        ).catch(
            erro => {
                notification.error({ description: "Falha ao retirar senha, tente novamente!", message: "Aviso" });
            }
        );
    };

    function resgatarSenha() {
        api.post('/Senha/ResgatarSenha').then(
            res => {
                let dados = res.data;
                if (!!dados) {
                    form.setFieldsValue({ senhaAtual: dados.sen_senha });
                    notification.success({ description: `Senha chamada com sucesso, a senha atual é ${dados.sen_senha}`, message: "Sucesso" })
                }
            }
        ).catch(
            erro => {
                mensagemExcecao(erro);
            }
        )
    };

    function modalZerarSenhas() {
        Modal.confirm(
            {
                title: "Você tem certeza que deseja resetar as senhas?",
                icon: <ExclamationCircleOutlined />,
                content: "Esta operação é irreversivel!",
                onOk() {
                    zerarSenhas();
                }
            }
        );
    };

    function zerarSenhas() {
        api.delete(`/Senha/RemoverSenhas`).then(
            res => {
                notification.success({ description: "Senhas removidas com sucesso!", message: "Aviso" });
            }
        ).catch(
            erro => {
                mensagemExcecao(erro);
            }
        ).finally(
            () => {
                form.resetFields();
            }
        );
    };

    function abrirModalGerente() {
        setAbrirModalGerencial(!abrirModalGerencial);
    };

    return (
        <Layout style={{ height: "100%" }}>
            <Header >
                <Row justify="space-between" gutter={[8, 0]} >
                    <Col>
                        <Image src='logoPrincipalPariPassu.png' color='#fff' preview={false} />
                    </Col>
                    <Col>
                        <Button type='primary' onClick={() => { abrirModalGerente() }}>Abrir Configurações Gerenciais</Button>
                    </Col>
                </Row>
            </Header>
            <Content style={{ height: '100%' }}>
                <Form layout='vertical' form={form}>
                    <Row gutter={[8, 8]} justify='center' >
                        <Col span={12}>
                            <Form.Item name={"senhaAtual"} label="Senha Atual">
                                <Input disabled={true} />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Row gutter={[8, 8]} justify='center'>
                        <Col span={6}>
                            <Card title="Senhas Preferênciais" bordered={false}>
                                <Button type='primary' onClick={() => { pegarSenhaPreferencial() }}>Retirar Senha</Button>
                            </Card>
                        </Col>
                        <Col span={6} >
                            <Card title="Senhas Normais" bordered={false}>
                                <Button type='primary' onClick={() => { pegarSenhaNormal() }}>Retirar Senha</Button>
                            </Card>
                        </Col>
                    </Row>

                    <Modal
                        title="Controle Gerencial"
                        visible={abrirModalGerencial}
                        footer={null}
                        okButtonProps={{ hidden: true }}
                        onCancel={() => { abrirModalGerente() }}
                    >
                        <Card bordered={false}>
                            <Typography style={{ marginBottom: "10px" }}>
                                <Typography.Text>
                                    Selecione abaixo a operação que deseja executar para o gerenciamento das senhas
                                </Typography.Text>
                            </Typography>
                            <Row justify='center' gutter={[8, 8]}>
                                <Col><Button type='primary' onClick={() => { resgatarSenha() }}>Chamar Senha</Button></Col>
                                <Col><Button type='primary' onClick={() => { modalZerarSenhas() }}>Resetar Senhas</Button></Col>
                            </Row>
                        </Card>
                    </Modal>
                </Form>
            </Content>
        </Layout>
    )
}