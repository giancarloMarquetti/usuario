package com.glmbots.usuario.business.converter;

import com.glmbots.usuario.business.dto.EnderecoDTO;
import com.glmbots.usuario.business.dto.TelefoneDTO;
import com.glmbots.usuario.business.dto.UsuarioDTO;
import com.glmbots.usuario.infrastructure.entity.Endereco;
import com.glmbots.usuario.infrastructure.entity.Telefone;
import com.glmbots.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .cpfCnpj(usuarioDTO.getCpfCnpj())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .validado(usuarioDTO.getValidado())
                .tokenParaValidar(usuarioDTO.getTokenParaValidar())
                .novoEmail(usuarioDTO.getNovoEmail())
                .tokenNovoEmail(usuarioDTO.getTokenNovoEmail())
                .idAsaas(usuarioDTO.getIdAsaas())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .ddd(telefoneDTO.getDdd())
                .numero(telefoneDTO.getNumero())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .cpfCnpj(usuario.getCpfCnpj())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .validado(usuario.getValidado())
                .tokenParaValidar(usuario.getTokenParaValidar())
                .novoEmail(usuario.getNovoEmail())
                .tokenNovoEmail(usuario.getTokenNovoEmail())
                .idAsaas(usuario.getIdAsaas())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecos){
        return enderecos.stream().map(this::paraEnderecoDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco){
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefones){
        return telefones.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()
                .ddd(telefone.getDdd())
                .numero(telefone.getNumero())
                .build();
    }

}
