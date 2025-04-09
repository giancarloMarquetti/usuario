package com.glmbots.usuario.business.dto;

import com.glmbots.usuario.infrastructure.entity.Endereco;
import com.glmbots.usuario.infrastructure.entity.Telefone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    private String nome;
    private String cpfCnpj;
    private String email;
    private String senha;
    private Boolean validado;
    private String tokenParaValidar;
    private String novoEmail;
    private String tokenNovoEmail;
    private String idAsaas;
    private List<EnderecoDTO> enderecos;
    private List<TelefoneDTO> telefones;

}
