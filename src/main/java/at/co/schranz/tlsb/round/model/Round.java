
package at.co.schranz.tlsb.round.model;

import at.co.schranz.tlsb.round.model.base.BaseRound;
import at.generalsolutions.messaging.MessageContent;

public class Round extends BaseRound implements MessageContent{
	private static final long serialVersionUID = 1L;

	public Round(java.lang.Integer id) {
		super(id);
	}

	public Round () {
		super();
	}

	@Override
	public String getMessageObjectName() {
		// TODO Auto-generated method stub
		return "Round_" + getId();
	}

	@Override
	public Integer getMessageObjectId() {
		// TODO Auto-generated method stub
		return getId();
	}
}