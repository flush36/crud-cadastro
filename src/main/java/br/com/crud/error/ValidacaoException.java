package br.com.crud.error;

public class ValidacaoException extends Exception{

    private ErroDTO erroDTO;

    public ValidacaoException(ErroDTO erroDTO) {
        this.erroDTO = erroDTO;
    }

    public ErroDTO getErroDTO() {
        return erroDTO;
    }

    public void setErroDTO(ErroDTO erroDTO) {
        this.erroDTO = erroDTO;
    }
}
