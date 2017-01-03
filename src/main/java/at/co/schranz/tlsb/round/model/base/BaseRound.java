package at.co.schranz.tlsb.round.model.base;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class BaseRound implements Serializable, Cloneable {
	protected final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	public static String REF = "Round";
	public static final String PROP_ID = "id";
	public static final String PROP_ROUND = "round";
	public static final String PROP_START = "start";
	public static final String PROP_STOP = "stop";
	public static final String PROP_DIZIPLINE = "dizipline";
	public static final String PROP_ACTIVE = "active";
	public static final String PROP_DISTIRCT = "distirct";
	public static final String PROP_USE_HOBBY = "useHobby";

	private java.lang.Integer id;
	private java.lang.Integer round;
	private java.util.Date start;
	private java.util.Date stop;
	private java.lang.Integer dizipline;
	private java.lang.Boolean active;
	private String distirct;
	private java.lang.Boolean useHobby;


	// constructors
	public BaseRound() {
		this(-1);
	}

	/**
	* Constructor for primary key
	*/
	public BaseRound(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}

	private int hashCode = Integer.MIN_VALUE;
	/**
	*	Getter of id == id
	*/
	public java.lang.Integer getId() {
		return this.id;
	}
	/**
	*	Setter of id
	*   @param id 
	*/
	public void setId (java.lang.Integer id) {
		this.id = id;
	}

	/**
	*	Getter of round == round
	*/
	public java.lang.Integer getRound() {
		return this.round;
	}
	/**
	*	Setter of round
	*   @param round 
	*/
	public void setRound (java.lang.Integer round) {
		this.round = round;
	}

	/**
	*	Getter of start == start
	*/
	public java.util.Date getStart() {
		return this.start;
	}
	/**
	*	Setter of start
	*   @param start 
	*/
	public void setStart (java.util.Date start) {
		this.start = start;
	}

	/**
	*	Getter of stop == stop
	*/
	public java.util.Date getStop() {
		return this.stop;
	}
	/**
	*	Setter of stop
	*   @param stop 
	*/
	public void setStop (java.util.Date stop) {
		this.stop = stop;
	}

	/**
	*	Getter of dizipline == dizipline
	*/
	public java.lang.Integer getDizipline() {
		return this.dizipline;
	}
	/**
	*	Setter of dizipline
	*   @param dizipline 
	*/
	public void setDizipline (java.lang.Integer dizipline) {
		this.dizipline = dizipline;
	}

	/**
	*	Getter of active == active
	*/
	public java.lang.Boolean getActive() {
		return this.active;
	}
	/**
	*	Setter of active
	*   @param active 
	*/
	public void setActive (java.lang.Boolean active) {
		this.active = active;
	}

	/**
	*	Getter of distirct == distirct
	*/
	public String getDistirct() {
		return this.distirct;
	}
	/**
	*	Setter of distirct
	*   @param distirct 
	*/
	public void setDistirct (String distirct) {
		this.distirct = distirct;
	}

	/**
	*	Getter of useHobby == useHobby
	*/
	public java.lang.Boolean getUseHobby() {
		return this.useHobby;
	}
	/**
	*	Setter of useHobby
	*   @param useHobby 
	*/
	public void setUseHobby (java.lang.Boolean useHobby) {
		this.useHobby = useHobby;
	}

	public at.co.schranz.tlsb.round.model.Round clone() {
		at.co.schranz.tlsb.round.model.Round copy = null;
		try {
			copy = (at.co.schranz.tlsb.round.model.Round)super.clone();
			copy.setId(-1);
		}
			catch(Throwable e) {
				log.fatal("Exception while cloning object of type at.generalsolutions.tlsb.round.model.Round!",e);
			}
		return copy;
	}

	/**
	* Create a java.util.Map<String,Object> for JSON
	* @see at.generalsolutions.tlsb.round.model.base.BaseRound#toJson(java.util.Map, String)
	* @return
	* @deprecated try to use {@link #getJSon()}
	*/
	@Deprecated
	public java.util.Map<String,Object> toJson() {
		return toJson((java.util.Map)null, (String)null);
	}

	/**
	* Create a java.util.Map<String,Object> for JSON
	* @param json java.util.Map<String,Object>
	* @param prefix Prefix for Keys
	* @return	
	 * <pre><code>
	* id=id
	* round=round
	* start=start
	* stop=stop
	* dizipline=dizipline
	* active=active
	* distirct=distirct
	* useHobby=useHobby
	 * </code></pre>

	* @deprecated try to use {@link #getJSon()}
	*/
	@Deprecated
	public java.util.Map<String,Object> toJson(java.util.Map<String,Object> json, String prefix) {
		if (json == null) {
			json = new java.util.HashMap<String,Object>();
		}
		if (prefix == null) {
			prefix = "";
		}
		json.put(prefix + PROP_ID,id);
		json.put(prefix + PROP_ROUND,round);
		json.put(prefix + PROP_START,start !=null? start.getTime():"");
		json.put(prefix + PROP_STOP,stop !=null? stop.getTime():"");
		json.put(prefix + PROP_DIZIPLINE,dizipline);
		json.put(prefix + PROP_ACTIVE,active);
		json.put(prefix + PROP_DISTIRCT,distirct);
		json.put(prefix + PROP_USE_HOBBY,useHobby);
		return json;
	}

	@JsonIgnore
	public String getJSon() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return mapper.writeValueAsString(this);
	}

	public void setProperty(String propertyName, Object value) {
		if 	(propertyName.equals("id")) {
			if (value instanceof java.lang.Integer) {
				setId((java.lang.Integer) value);
			}
			else {
				if (value == null) {
					setId(null); //Luggi oberspezialitaet !
				}
				else {
					setId(Integer.valueOf(value.toString()));
				}
			}
		}


		else if	(propertyName.equals("round")) {
			if (value instanceof java.lang.Integer) {
				setRound((java.lang.Integer) value);
			}
			else {
				if (value == null) {
					setRound(null); //Luggi oberspezialitaet !
				}
				else {
					setRound(Integer.valueOf(value.toString()));
				}
			}
		}


		else if	(propertyName.equals("start")) {
			if (value instanceof java.util.Date) {
				setStart((java.util.Date) value);
			}
			else {
				if (value == null) {
					setStart(null);
				}
				else {
					java.text.SimpleDateFormat[] formats = {
					new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"),
					new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"),
					new java.text.SimpleDateFormat("dd.MM.yyyy"),
					new java.text.SimpleDateFormat("yyyy-MM-dd")
				};

				for (java.text.SimpleDateFormat format : formats) {
					try {
						java.util.Date date = format.parse(value.toString());
						setStart(date);
						break;
					} catch (java.text.ParseException e) {
					log.debug("Couldn't parse date from string.", e);
					}
				}
			}
			}
		}


		else if	(propertyName.equals("stop")) {
			if (value instanceof java.util.Date) {
				setStop((java.util.Date) value);
			}
			else {
				if (value == null) {
					setStop(null);
				}
				else {
					java.text.SimpleDateFormat[] formats = {
					new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"),
					new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"),
					new java.text.SimpleDateFormat("dd.MM.yyyy"),
					new java.text.SimpleDateFormat("yyyy-MM-dd")
				};

				for (java.text.SimpleDateFormat format : formats) {
					try {
						java.util.Date date = format.parse(value.toString());
						setStop(date);
						break;
					} catch (java.text.ParseException e) {
					log.debug("Couldn't parse date from string.", e);
					}
				}
			}
			}
		}


		else if	(propertyName.equals("dizipline")) {
			if (value instanceof java.lang.Integer) {
				setDizipline((java.lang.Integer) value);
			}
			else {
				if (value == null) {
					setDizipline(null); //Luggi oberspezialitaet !
				}
				else {
					setDizipline(Integer.valueOf(value.toString()));
				}
			}
		}


		else if	(propertyName.equals("active")) {
			if (value instanceof java.lang.Boolean) {
				setActive((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("distirct")) {
			if (value instanceof String) {
				setDistirct((String) value);
			}
			else {
				if (value == null) {
					setDistirct(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("useHobby")) {
			if (value instanceof java.lang.Boolean) {
				setUseHobby((java.lang.Boolean) value);
			}
			else {
			}
		}

	}
	public Object getProperty(String propertyName) {
		if (propertyName.equals("id")) {
			return getId();
		}
		else if(propertyName.equals("round")) {
			return getRound();
		}
		else if(propertyName.equals("start")) {
			return getStart();
		}
		else if(propertyName.equals("stop")) {
			return getStop();
		}
		else if(propertyName.equals("dizipline")) {
			return getDizipline();
		}
		else if(propertyName.equals("active")) {
			return getActive();
		}
		else if(propertyName.equals("distirct")) {
			return getDistirct();
		}
		else if(propertyName.equals("useHobby")) {
			return getUseHobby();
		}
		return null;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
			if (!(obj instanceof at.co.schranz.tlsb.round.model.Round)) return false;
		else {
			at.co.schranz.tlsb.round.model.Round other = (at.co.schranz.tlsb.round.model.Round) obj;
				if (this.getId() == -1 && other.getId() == -1) {
					return false;
				}
			return (this.getId() == other.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}

	@Override
	public String toString() {
		return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this,org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE);
	}
}
