import React, { useState, useContext } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import UsuarioService from '../services/UsuarioService';
import './Login.css';

const Login = () => {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');
  const navigate = useNavigate();
  const { setUsuarioAutenticado } = useContext(AuthContext);
  const usuarioService = new UsuarioService();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await usuarioService.autenticarUsuario({ email, senha });
      setUsuarioAutenticado(response.data);
      navigate('/');
    } catch (error) {
      setErro('Email ou senha inválidos');
      console.error(error);
    }
  };

  return (
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Senha</label>
          <input
            type="password"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
          />
        </div>
        {erro && <p className="erro">{erro}</p>}
        <button type="submit">Login</button>
      </form>
      <div className="register-link">
        <p>Não tem uma conta? <Link to="/cadastro">Cadastre-se</Link></p>
      </div>
    </div>
  );
};

export default Login;