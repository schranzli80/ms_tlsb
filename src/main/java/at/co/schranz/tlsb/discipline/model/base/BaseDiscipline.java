package at.co.schranz.tlsb.discipline.model.base;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class BaseDiscipline implements Serializable, Cloneable {
	protected final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	public static String REF = "Diszipline";
	public static final String PROP_ID = "id";
	public static final String PROP_NAME = "name";
	public static final String PROP_WEAPON = "weapon";
	public static final String PROP_S_T = "s_t";
	public static final String PROP_ZEHNTEL = "zehntel";
	public static final String PROP_MORE_DESTRICT = "moreDestrict";
	public static final String PROP_PICTURE_PRINT = "picturePrint";
	public static final String PROP_PICTURE_HEIGHT = "pictureHeight";
	public static final String PROP_PICTURE_WIDTH = "pictureWidth";
	public static final String PROP_MIN_ANZ = "minAnz";
	public static final String PROP_ERG_STATE = "ergState";
	public static final String PROP_DESTRICT_STR = "destrictStr";
	public static final String PROP_ACTIVE = "active";

	private java.lang.Integer id;
	private String name;
	private String weapon;
	private boolean s_t;
	private boolean zehntel;
	private boolean moreDestrict;
	private String picturePrint;
	private java.lang.Integer pictureHeight;
	private java.lang.Integer pictureWidth;
	private boolean minAnz;
	private boolean ergState;
	private String destrictStr;
	private boolean active;


	// constructors
	public BaseDiscipline() {
		this(-1);
	}

	/**
	* Constructor for primary key
	*/
	public BaseDiscipline(java.lang.Integer id) {
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
	*	Getter of name == name
	*/
	public String getName() {
		return this.name;
	}
	/**
	*	Setter of name
	*   @param name 
	*/
	public void setName (String name) {
		this.name = name;
	}

	/**
	*	Getter of weapon == weapon
	*/
	public String getWeapon() {
		return this.weapon;
	}
	/**
	*	Setter of weapon
	*   @param weapon 
	*/
	public void setWeapon (String weapon) {
		this.weapon = weapon;
	}

	/**
	*	Getter of s_t == s_t
	*/
	public boolean isS_t() {
		return this.s_t;
	}
	/**
	*	Setter of s_t
	*   @param s_t 
	*/
	public void setS_t (boolean s_t) {
		this.s_t = s_t;
	}

	/**
	*	Getter of zehntel == zehntel
	*/
	public boolean isZehntel() {
		return this.zehntel;
	}
	/**
	*	Setter of zehntel
	*   @param zehntel 
	*/
	public void setZehntel (boolean zehntel) {
		this.zehntel = zehntel;
	}

	/**
	*	Getter of moreDestrict == moreDestrict
	*/
	public boolean isMoreDestrict() {
		return this.moreDestrict;
	}
	/**
	*	Setter of moreDestrict
	*   @param moreDestrict 
	*/
	public void setMoreDestrict (boolean moreDestrict) {
		this.moreDestrict = moreDestrict;
	}

	/**
	*	Getter of picturePrint == picturePrint
	*/
	public String getPicturePrint() {
		return this.picturePrint;
	}
	/**
	*	Setter of picturePrint
	*   @param picturePrint 
	*/
	public void setPicturePrint (String picturePrint) {
		this.picturePrint = picturePrint;
	}

	/**
	*	Getter of pictureHeight == pictureHeight
	*/
	public java.lang.Integer getPictureHeight() {
		return this.pictureHeight;
	}
	/**
	*	Setter of pictureHeight
	*   @param pictureHeight 
	*/
	public void setPictureHeight (java.lang.Integer pictureHeight) {
		this.pictureHeight = pictureHeight;
	}

	/**
	*	Getter of pictureWidth == pictureWidth
	*/
	public java.lang.Integer getPictureWidth() {
		return this.pictureWidth;
	}
	/**
	*	Setter of pictureWidth
	*   @param pictureWidth 
	*/
	public void setPictureWidth (java.lang.Integer pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	/**
	*	Getter of minAnz == minAnz
	*/
	public boolean isMinAnz() {
		return this.minAnz;
	}
	/**
	*	Setter of minAnz
	*   @param minAnz 
	*/
	public void setMinAnz (boolean minAnz) {
		this.minAnz = minAnz;
	}

	/**
	*	Getter of ergState == ergState
	*/
	public boolean isErgState() {
		return this.ergState;
	}
	/**
	*	Setter of ergState
	*   @param ergState 
	*/
	public void setErgState (boolean ergState) {
		this.ergState = ergState;
	}

	/**
	*	Getter of destrictStr == destrictStr
	*/
	public String getDestrictStr() {
		return this.destrictStr;
	}
	/**
	*	Setter of destrictStr
	*   @param destrictStr 
	*/
	public void setDestrictStr (String destrictStr) {
		this.destrictStr = destrictStr;
	}

	/**
	*	Getter of active == active
	*/
	public boolean isActive() {
		return this.active;
	}
	/**
	*	Setter of active
	*   @param active 
	*/
	public void setActive (boolean active) {
		this.active = active;
	}

	public at.co.schranz.tlsb.discipline.model.Discipline clone() {
		at.co.schranz.tlsb.discipline.model.Discipline copy = null;
		try {
			copy = (at.co.schranz.tlsb.discipline.model.Discipline)super.clone();
			copy.setId(-1);
		}
			catch(Throwable e) {
				log.fatal("Exception while cloning object of type at.co.schranz.tlsb.diszipline.model.Diszipline!",e);
			}
		return copy;
	}

	/**
	* Create a java.util.Map<String,Object> for JSON
	* @see at.co.schranz.tlsb.discipline.model.base.BaseDiscipline#toJson(java.util.Map, String)
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
	* name=name
	* weapon=weapon
	* s_t=s_t
	* zehntel=zehntel
	* moreDestrict=moreDestrict
	* picturePrint=picturePrint
	* pictureHeight=pictureHeight
	* pictureWidth=pictureWidth
	* minAnz=minAnz
	* ergState=ergState
	* destrictStr=destrictStr
	* active=active
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
		json.put(prefix + PROP_NAME,name);
		json.put(prefix + PROP_WEAPON,weapon);
		json.put(prefix + PROP_S_T,s_t);
		json.put(prefix + PROP_ZEHNTEL,zehntel);
		json.put(prefix + PROP_MORE_DESTRICT,moreDestrict);
		json.put(prefix + PROP_PICTURE_PRINT,picturePrint);
		json.put(prefix + PROP_PICTURE_HEIGHT,pictureHeight);
		json.put(prefix + PROP_PICTURE_WIDTH,pictureWidth);
		json.put(prefix + PROP_MIN_ANZ,minAnz);
		json.put(prefix + PROP_ERG_STATE,ergState);
		json.put(prefix + PROP_DESTRICT_STR,destrictStr);
		json.put(prefix + PROP_ACTIVE,active);
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


		else if	(propertyName.equals("name")) {
			if (value instanceof String) {
				setName((String) value);
			}
			else {
				if (value == null) {
					setName(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("weapon")) {
			if (value instanceof String) {
				setWeapon((String) value);
			}
			else {
				if (value == null) {
					setWeapon(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("s_t")) {
			if (value instanceof java.lang.Boolean) {
				setS_t((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("zehntel")) {
			if (value instanceof java.lang.Boolean) {
				setZehntel((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("moreDestrict")) {
			if (value instanceof java.lang.Boolean) {
				setMoreDestrict((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("picturePrint")) {
			if (value instanceof String) {
				setPicturePrint((String) value);
			}
			else {
				if (value == null) {
					setPicturePrint(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("pictureHeight")) {
			if (value instanceof java.lang.Integer) {
				setPictureHeight((java.lang.Integer) value);
			}
			else {
				if (value == null) {
					setPictureHeight(null); //Luggi oberspezialitaet !
				}
				else {
					setPictureHeight(Integer.valueOf(value.toString()));
				}
			}
		}


		else if	(propertyName.equals("pictureWidth")) {
			if (value instanceof java.lang.Integer) {
				setPictureWidth((java.lang.Integer) value);
			}
			else {
				if (value == null) {
					setPictureWidth(null); //Luggi oberspezialitaet !
				}
				else {
					setPictureWidth(Integer.valueOf(value.toString()));
				}
			}
		}


		else if	(propertyName.equals("minAnz")) {
			if (value instanceof java.lang.Boolean) {
				setMinAnz((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("ergState")) {
			if (value instanceof java.lang.Boolean) {
				setErgState((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("destrictStr")) {
			if (value instanceof String) {
				setDestrictStr((String) value);
			}
			else {
				if (value == null) {
					setDestrictStr(null); //Luggi OBER - OBER - oberspezialitaet !
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

	}
	public Object getProperty(String propertyName) {
		if (propertyName.equals("id")) {
			return getId();
		}
		else if(propertyName.equals("name")) {
			return getName();
		}
		else if(propertyName.equals("weapon")) {
			return getWeapon();
		}
		else if(propertyName.equals("s_t")) {
			return isS_t();
		}
		else if(propertyName.equals("zehntel")) {
			return isZehntel();
		}
		else if(propertyName.equals("moreDestrict")) {
			return isMoreDestrict();
		}
		else if(propertyName.equals("picturePrint")) {
			return getPicturePrint();
		}
		else if(propertyName.equals("pictureHeight")) {
			return getPictureHeight();
		}
		else if(propertyName.equals("pictureWidth")) {
			return getPictureWidth();
		}
		else if(propertyName.equals("minAnz")) {
			return isMinAnz();
		}
		else if(propertyName.equals("ergState")) {
			return isErgState();
		}
		else if(propertyName.equals("destrictStr")) {
			return getDestrictStr();
		}
		else if(propertyName.equals("active")) {
			return isActive();
		}
		return null;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
			if (!(obj instanceof at.co.schranz.tlsb.discipline.model.Discipline)) return false;
		else {
			at.co.schranz.tlsb.discipline.model.Discipline other = (at.co.schranz.tlsb.discipline.model.Discipline) obj;
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
