
package at.co.schranz.tlsb.shooter.model;

import java.util.Date;

import at.co.schranz.tlsb.shooter.model.base.BaseShooter;
import at.generalsolutions.messaging.MessageContent;

public class Shooter extends BaseShooter implements MessageContent{
	private static final long serialVersionUID = 1L;

	public Shooter(java.lang.Integer id) {
		super(id);
		this.setSignIn(new Date());
	}

	public Shooter () {
		super();
		
	}

	@Override
	public String getMessageObjectName() {
		// TODO Auto-generated method stub
		return "Shooter_" + getId();
	}

	@Override
	public Integer getMessageObjectId() {
		// TODO Auto-generated method stub
		return getId();
	}
}