import api from '../api/axios';
import bcrypt from 'bcryptjs';

const API_URL = 'http://localhost:8080/usuarios';

class UsuarioService {
    login(credenciais) {
        return api.post('/auth/login', credenciais);
    }

    obterSaldoUsuario(id) {
        return api.get(`/usuarios/${id}/saldo`);
    }

    async cadastrarUsuario(usuario) {
        const salt = await bcrypt.genSalt(10);
        const senhaCriptografada = await bcrypt.hash(usuario.senha, salt);

        const usuarioParaCadastro = {
            nome: usuario.nome,
            email: usuario.email,
            senha: senhaCriptografada
        };

        return api.post(API_URL, usuarioParaCadastro);
    }
}

export default UsuarioService;
