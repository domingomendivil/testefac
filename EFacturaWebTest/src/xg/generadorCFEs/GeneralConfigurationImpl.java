package xg.generadorCFEs;

import java.util.Date;

import xg.caebusiness.GeneralConfiguration;

public class GeneralConfigurationImpl implements GeneralConfiguration {

	private Date fechaActual;
	public void setFechaActual(Date date){
		fechaActual = date;
	}
	@Override
	public Date getFechaActual() {
		return fechaActual;
	}

}
