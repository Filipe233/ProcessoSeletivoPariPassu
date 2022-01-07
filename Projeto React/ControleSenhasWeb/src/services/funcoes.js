import { notification } from "antd";

export default function mensagemExcecao(erro, titulo = "Aviso") {
    if (!!erro.response && !!erro.response.data && !!erro.response.data.message) {
        notification.error({ description: erro.response.data.message, message: titulo });
    } else {
        console.log(erro);
    }
}