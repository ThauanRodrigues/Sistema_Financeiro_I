import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Lancamentos from './pages/Lancamentos';
import Categorias from './pages/Categorias';
import Pessoas from './pages/Pessoas';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro';
import PrivateRoute from './components/PrivateRoute';
import { AuthProvider } from './context/AuthContext';

function App() {
    return (
        <AuthProvider>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/cadastro" element={<Cadastro />} />
                <Route path="/" element={<PrivateRoute component={Home} />} />
                <Route path="/lancamentos" element={<PrivateRoute component={Lancamentos} />} />
                <Route path="/categorias" element={<PrivateRoute component={Categorias} />} />
                <Route path="/pessoas" element={<PrivateRoute component={Pessoas} />} />
            </Routes>
        </AuthProvider>
    );
}

export default App;