package com.glmbots.usuario.business.converter;

import com.glmbots.usuario.business.dto.EnderecoDTO;
import com.glmbots.usuario.business.dto.TelefoneDTO;
import com.glmbots.usuario.business.dto.UsuarioDTO;
import com.glmbots.usuario.infrastructure.entity.Endereco;
import com.glmbots.usuario.infrastructure.entity.Telefone;
import com.glmbots.usuario.infrastructure.entity.Usuario;
import jakarta.persistence.Column;
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
                .id(endereco.getId())
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
                .id(telefone.getId())
                .ddd(telefone.getDdd())
                .numero(telefone.getNumero())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO dto, Usuario entity){
        return Usuario.builder()
                .id(entity.getId())
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .cpfCnpj(dto.getCpfCnpj() != null ? dto.getCpfCnpj() : entity.getCpfCnpj())
                .email(dto.getEmail() != null ? dto.getEmail() : entity.getEmail())
                .senha(dto.getSenha() != null ? dto.getSenha() : entity.getSenha())
                .validado(dto.getValidado() != null ? dto.getValidado() : entity.getValidado())
                .tokenParaValidar(dto.getTokenParaValidar() != null ? dto.getTokenParaValidar() : entity.getTokenParaValidar())
                .novoEmail(dto.getNovoEmail() != null ? dto.getNovoEmail() : entity.getNovoEmail())
                .tokenNovoEmail(dto.getTokenNovoEmail() != null ? dto.getTokenNovoEmail() : entity.getTokenNovoEmail())
                .idAsaas(dto.getIdAsaas() != null ? dto.getIdAsaas() : entity.getIdAsaas())
                .enderecos(entity.getEnderecos())
                .telefones(entity.getTelefones())
                .build();
    }

    public Endereco updateEndereco(EnderecoDTO dto, Endereco entity){
        return Endereco.builder()
                .id(entity.getId())
                .rua(dto.getRua() != null ? dto.getRua() : entity.getRua())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .complemento(dto.getComplemento() != null ? dto.getComplemento() : entity.getComplemento())
                .cidade(dto.getCidade() != null ? dto.getCidade() : entity.getCidade())
                .estado(dto.getEstado() != null ? dto.getEstado() : entity.getEstado())
                .cep(dto.getCep() != null ? dto.getCep() : entity.getCep())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO dto, Telefone entity){
        return Telefone.builder()
                .id(entity.getId())
                .ddd(dto.getDdd() != null ? dto.getDdd() : entity.getDdd())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .build();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO, Long idUsuario){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .usuario_id(idUsuario)
                .build();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO, Long idUsuario){
        return Telefone.builder()
                .ddd(telefoneDTO.getDdd())
                .numero(telefoneDTO.getNumero())
                .usuario_id(idUsuario)
                .build();
    }

}
