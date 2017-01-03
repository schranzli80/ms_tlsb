
package at.co.schranz.tlsb.discipline.model;

import at.co.schranz.tlsb.discipline.model.base.BaseDiscipline;
import at.generalsolutions.messaging.MessageContent;

public class Discipline extends BaseDiscipline implements MessageContent{
	private static final long serialVersionUID = 1L;

	public Discipline(java.lang.Integer id) {
		super(id);
	}

	public Discipline () {
		super();
	}

	@Override
	public String getMessageObjectName() {
		// TODO Auto-generated method stub
		return "Diszipline_" + getId();
	}

	@Override
	public Integer getMessageObjectId() {
		// TODO Auto-generated method stub
		return getId();
	}
}