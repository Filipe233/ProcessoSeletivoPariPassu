import React, { useState } from 'react';
import { Col, Input, Form, InputNumber, Row, Button, notification } from 'antd';
import axios from 'axios';
import api from '../../services/api';
import { urlPadrao } from '../../services';
import mensagemExcecao from '../../services/funcoes';


/*
    Não será mais utilizado
*/

export default function Login(teste) {
    const [form] = Form.useForm();

    const efetuarLogin = () => {
        let usuario = form.getFieldValue().log_usuario;
        let senha = form.getFieldValue().log_senha;
        api.post(`/Usuario/Login?nome=${usuario}&senha=${senha}`).then(
            (res) => {
                let dados = res.data;
                usuarioLogado(dados);
            }
        ).catch(
            erro => {
                mensagemExcecao(erro);
            }
        )
    };

    function usuarioLogado(usuario) {
        localStorage.setItem("Usuario", usuario.usu_nome);
        localStorage.setItem("Gerente", usuario.usu_gerente);
        window.location = urlPadrao;
    };

    return (
        <div style={{ margin: `10px` }}>
            <Form layout="vertical" form={form} onFinish={efetuarLogin}>
                <Row gutter={[8, 8]}>
                    <Col>
                        <Form.Item label="Usuario" name="log_usuario" rules={[{ required: true, message: 'Favor informar o usuario!' }]} >
                            <Input placeholder='insira o usuario' onPressEnter={() => { form.submit() }} />
                        </Form.Item>
                    </Col>
                    <Col>
                        <Form.Item label="Senha" name="log_senha" rules={[{ required: true, message: 'Favor informar a senha!' }]}>
                            <Input.Password placeholder="insira a senha" onPressEnter={() => { form.submit() }} />
                        </Form.Item>
                    </Col>
                </Row>
                <Row>
                    <Button type='primary' onClick={() => { form.submit() }} >Login</Button>
                </Row>
            </Form>
        </div>
    )

}