package br.com.italo.mapper;

import br.com.italo.repository.Papel;
import br.com.italo.rest.response.PapelBean;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-07T15:50:02-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
public class PapelMapperImpl implements PapelMapper {

    @Override
    public PapelBean papelToPapelBean(Papel papel) {
        if ( papel == null ) {
            return null;
        }

        PapelBean papelBean = new PapelBean();

        papelBean.setEvEbit( papel.getEvEbit() );
        papelBean.setRoic( papel.getRoic() );
        papelBean.setSigla( papel.getSigla() );
        papelBean.setMrgLiq( papel.getMrgLiq() );
        papelBean.setLiqCorr( papel.getLiqCorr() );
        papelBean.setRoe( papel.getRoe() );
        papelBean.setPvp( papel.getPvp() );
        papelBean.setPsr( papel.getPsr() );
        papelBean.setPCapGiro( papel.getPCapGiro() );
        papelBean.setPEbit( papel.getPEbit() );
        papelBean.setDivYeld( papel.getDivYeld() );
        papelBean.setPAtivo( papel.getPAtivo() );
        papelBean.setPAtivCircLiq( papel.getPAtivCircLiq() );
        papelBean.setMrgEbit( papel.getMrgEbit() );
        papelBean.setLiq2meses( papel.getLiq2meses() );
        papelBean.setDivBrutPatrim( papel.getDivBrutPatrim() );
        papelBean.setPatrimLiq( papel.getPatrimLiq() );
        papelBean.setCotacao( papel.getCotacao() );
        papelBean.setPl( papel.getPl() );
        papelBean.setEvEbitida( papel.getEvEbitida() );
        papelBean.setCrescrec5a( papel.getCrescrec5a() );

        return papelBean;
    }
}
