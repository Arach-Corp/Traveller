package br.com.fiap.traveller.entities.dto;

import br.com.fiap.traveller.entities.Endereco;

public class EnderecoDTO {
        private Long id;
        private String logradouro;
        private String numero;


        public EnderecoDTO() {
        }

        public EnderecoDTO(Long id, String logradouro, String numero) {
                this.id = id;
                this.logradouro = logradouro;
                this.numero = numero;
        }

        public EnderecoDTO(Endereco endereco){
                setId(endereco.getId());
                setLogradouro(endereco.getLogradouro());
                setNumero(endereco.getNumero());
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getLogradouro() {
                return logradouro;
        }

        public void setLogradouro(String logradouro) {
                this.logradouro = logradouro;
        }

        public String getNumero() {
                return numero;
        }

        public void setNumero(String numero) {
                this.numero = numero;
        }
}
