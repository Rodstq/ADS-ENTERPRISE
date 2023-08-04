package testes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controladores.Cliente.ClienteConsultaDatabase;
import data.tratamento.clients.ClienteConsultaTratamento;
import data.tratamento.clients.Clientes;
import data.tratamento.clients.infoClienteException;
import interfaces.interfacesCliente.InterfaceConsultaCliente;

public class ClienteConsultaTratamentoTeste {

    private InterfaceConsultaCliente mockData;

    @Before
    public void setUp() {

        mockData = mock(ClienteConsultaDatabase.class);
    }

    @Test
    public void testSetConsultaNomeClienteEndereco() throws infoClienteException {

        ClienteConsultaTratamento tratamento = new ClienteConsultaTratamento(mockData);

        String nome = "Julia";
        Clientes info = new Clientes();
        info.setNomeCliente(nome);

        List<Object[]> resultadosEsperados = new ArrayList<>();

        when(mockData.infoCliente(info)).thenReturn(resultadosEsperados);


        List<Object[]> resultadosCliente = tratamento.setConsultaNomeClienteEndereco(nome);


        verify(mockData).infoCliente(info);


        assertEquals(resultadosEsperados, resultadosCliente);
    }

    @Test
    public void testSetConsultaCpfClienteEndereco() throws infoClienteException {

        ClienteConsultaTratamento tratamento = new ClienteConsultaTratamento(mockData);


        String cpf = "12345678901";
        Clientes info = new Clientes();
        info.setCpf(cpf);

        List<Object[]> resultadosEsperados = new ArrayList<>();


        when(mockData.infoClienteCpf(info)).thenReturn(resultadosEsperados);


        List<Object[]> resultadosCliente = tratamento.setConsultaCpfClienteEndereco(cpf);


        verify(mockData).infoClienteCpf(info);


        assertEquals(resultadosEsperados, resultadosCliente);
    }

}
