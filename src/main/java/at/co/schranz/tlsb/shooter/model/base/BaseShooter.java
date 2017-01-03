package at.co.schranz.tlsb.shooter.model.base;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class BaseShooter implements Serializable, Cloneable {
	protected final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	public static String REF = "Shooter";
	public static final String PROP_ID = "id";
	public static final String PROP_SIGN_IN = "signIn";
	public static final String PROP_LAST_UPDATE = "lastUpdate";
	public static final String PROP_NAME = "name";
	public static final String PROP_PASS_NR = "passNr";
	public static final String PROP_COMMUNITY = "community";
	public static final String PROP_SEX = "sex";
	public static final String PROP_BIRTHDAY = "birthday";
	public static final String PROP_ARMBRUST = "armbrust";
	public static final String PROP_GK = "gk";
	public static final String PROP_FEUERSTUTZEN = "feuerstutzen";
	public static final String PROP_FEUERPISTOLE = "feuerpistole";
	public static final String PROP_FP = "fp";
	public static final String PROP_KK = "kk";
	public static final String PROP_LG = "lg";
	public static final String PROP_LP = "lp";
	public static final String PROP_LP5 = "lp5";
	public static final String PROP_VORDERLADER = "vorderlader";
	public static final String PROP_ZIMMERSTUTZEN = "zimmerstutzen";

	private java.lang.Integer id;
	private java.util.Date signIn;
	private java.util.Date lastUpdate;
	private String name;
	private String passNr;
	private String community;
	private String sex;
	private java.util.Date birthday;
	private boolean armbrust;
	private boolean gk;
	private boolean feuerstutzen;
	private boolean feuerpistole;
	private boolean fp;
	private boolean kk;
	private boolean lg;
	private boolean lp;
	private boolean lp5;
	private boolean vorderlader;
	private boolean zimmerstutzen;


	// constructors
	public BaseShooter() {
		this(-1);
	}

	/**
	* Constructor for primary key
	*/
	public BaseShooter(java.lang.Integer id) {
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
	*	Getter of signIn == signIn
	*/
	public java.util.Date getSignIn() {
		return this.signIn;
	}
	/**
	*	Setter of signIn
	*   @param signIn 
	*/
	public void setSignIn (java.util.Date signIn) {
		this.signIn = signIn;
	}

	/**
	*	Getter of lastUpdate == lastUpdate
	*/
	public java.util.Date getLastUpdate() {
		return this.lastUpdate;
	}
	/**
	*	Setter of lastUpdate
	*   @param lastUpdate 
	*/
	public void setLastUpdate (java.util.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
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
	*	Getter of passNr == passNr
	*/
	public String getPassNr() {
		return this.passNr;
	}
	/**
	*	Setter of passNr
	*   @param passNr 
	*/
	public void setPassNr (String passNr) {
		this.passNr = passNr;
	}

	/**
	*	Getter of community == community
	*/
	public String getCommunity() {
		return this.community;
	}
	/**
	*	Setter of community
	*   @param community 
	*/
	public void setCommunity (String community) {
		this.community = community;
	}

	/**
	*	Getter of sex == sex
	*/
	public String getSex() {
		return this.sex;
	}
	/**
	*	Setter of sex
	*   @param sex 
	*/
	public void setSex (String sex) {
		this.sex = sex;
	}

	/**
	*	Getter of birthday == birthday
	*/
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	/**
	*	Setter of birthday
	*   @param birthday 
	*/
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
	}

	/**
	*	Getter of armbrust == armbrust
	*/
	public boolean isArmbrust() {
		return this.armbrust;
	}
	/**
	*	Setter of armbrust
	*   @param armbrust 
	*/
	public void setArmbrust (boolean armbrust) {
		this.armbrust = armbrust;
	}

	/**
	*	Getter of gk == gk
	*/
	public boolean isGk() {
		return this.gk;
	}
	/**
	*	Setter of gk
	*   @param gk 
	*/
	public void setGk (boolean gk) {
		this.gk = gk;
	}

	/**
	*	Getter of feuerstutzen == feuerstutzen
	*/
	public boolean isFeuerstutzen() {
		return this.feuerstutzen;
	}
	/**
	*	Setter of feuerstutzen
	*   @param feuerstutzen 
	*/
	public void setFeuerstutzen (boolean feuerstutzen) {
		this.feuerstutzen = feuerstutzen;
	}

	/**
	*	Getter of feuerpistole == feuerpistole
	*/
	public boolean isFeuerpistole() {
		return this.feuerpistole;
	}
	/**
	*	Setter of feuerpistole
	*   @param feuerpistole 
	*/
	public void setFeuerpistole (boolean feuerpistole) {
		this.feuerpistole = feuerpistole;
	}

	/**
	*	Getter of fp == fp
	*/
	public boolean isFp() {
		return this.fp;
	}
	/**
	*	Setter of fp
	*   @param fp 
	*/
	public void setFp (boolean fp) {
		this.fp = fp;
	}

	/**
	*	Getter of kk == kk
	*/
	public boolean isKk() {
		return this.kk;
	}
	/**
	*	Setter of kk
	*   @param kk 
	*/
	public void setKk (boolean kk) {
		this.kk = kk;
	}

	/**
	*	Getter of lg == lg
	*/
	public boolean isLg() {
		return this.lg;
	}
	/**
	*	Setter of lg
	*   @param lg 
	*/
	public void setLg (boolean lg) {
		this.lg = lg;
	}

	/**
	*	Getter of lp == lp
	*/
	public boolean isLp() {
		return this.lp;
	}
	/**
	*	Setter of lp
	*   @param lp 
	*/
	public void setLp (boolean lp) {
		this.lp = lp;
	}

	/**
	*	Getter of lp5 == lp5
	*/
	public boolean isLp5() {
		return this.lp5;
	}
	/**
	*	Setter of lp5
	*   @param lp5 
	*/
	public void setLp5 (boolean lp5) {
		this.lp5 = lp5;
	}

	/**
	*	Getter of vorderlader == vorderlader
	*/
	public boolean isVorderlader() {
		return this.vorderlader;
	}
	/**
	*	Setter of vorderlader
	*   @param vorderlader 
	*/
	public void setVorderlader (boolean vorderlader) {
		this.vorderlader = vorderlader;
	}

	/**
	*	Getter of zimmerstutzen == zimmerstutzen
	*/
	public boolean isZimmerstutzen() {
		return this.zimmerstutzen;
	}
	/**
	*	Setter of zimmerstutzen
	*   @param zimmerstutzen 
	*/
	public void setZimmerstutzen (boolean zimmerstutzen) {
		this.zimmerstutzen = zimmerstutzen;
	}

	public at.co.schranz.tlsb.shooter.model.Shooter clone() {
		at.co.schranz.tlsb.shooter.model.Shooter copy = null;
		try {
			copy = (at.co.schranz.tlsb.shooter.model.Shooter)super.clone();
			copy.setId(-1);
		}
			catch(Throwable e) {
				log.fatal("Exception while cloning object of type at.generalsolutions.tlsb.shooter.model.Shooter!",e);
			}
		return copy;
	}

	/**
	* Create a java.util.Map<String,Object> for JSON
	* @see at.co.schranz.tlsb.shooter.model.base.BaseShooter#toJson(java.util.Map, String)
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
	* signIn=signIn
	* lastUpdate=lastUpdate
	* name=name
	* passNr=passNr
	* community=community
	* sex=sex
	* birthday=birthday
	* armbrust=armbrust
	* gk=gk
	* feuerstutzen=feuerstutzen
	* feuerpistole=feuerpistole
	* fp=fp
	* kk=kk
	* lg=lg
	* lp=lp
	* lp5=lp5
	* vorderlader=vorderlader
	* zimmerstutzen=zimmerstutzen
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
		json.put(prefix + PROP_SIGN_IN,signIn !=null? signIn.getTime():"");
		json.put(prefix + PROP_LAST_UPDATE,lastUpdate !=null? lastUpdate.getTime():"");
		json.put(prefix + PROP_NAME,name);
		json.put(prefix + PROP_PASS_NR,passNr);
		json.put(prefix + PROP_COMMUNITY,community);
		json.put(prefix + PROP_SEX,sex);
		json.put(prefix + PROP_BIRTHDAY,birthday !=null? birthday.getTime():"");
		json.put(prefix + PROP_ARMBRUST,armbrust);
		json.put(prefix + PROP_GK,gk);
		json.put(prefix + PROP_FEUERSTUTZEN,feuerstutzen);
		json.put(prefix + PROP_FEUERPISTOLE,feuerpistole);
		json.put(prefix + PROP_FP,fp);
		json.put(prefix + PROP_KK,kk);
		json.put(prefix + PROP_LG,lg);
		json.put(prefix + PROP_LP,lp);
		json.put(prefix + PROP_LP5,lp5);
		json.put(prefix + PROP_VORDERLADER,vorderlader);
		json.put(prefix + PROP_ZIMMERSTUTZEN,zimmerstutzen);
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


		else if	(propertyName.equals("signIn")) {
			if (value instanceof java.util.Date) {
				setSignIn((java.util.Date) value);
			}
			else {
				if (value == null) {
					setSignIn(null);
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
						setSignIn(date);
						break;
					} catch (java.text.ParseException e) {
					log.debug("Couldn't parse date from string.", e);
					}
				}
			}
			}
		}


		else if	(propertyName.equals("lastUpdate")) {
			if (value instanceof java.util.Date) {
				setLastUpdate((java.util.Date) value);
			}
			else {
				if (value == null) {
					setLastUpdate(null);
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
						setLastUpdate(date);
						break;
					} catch (java.text.ParseException e) {
					log.debug("Couldn't parse date from string.", e);
					}
				}
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


		else if	(propertyName.equals("passNr")) {
			if (value instanceof String) {
				setPassNr((String) value);
			}
			else {
				if (value == null) {
					setPassNr(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("community")) {
			if (value instanceof String) {
				setCommunity((String) value);
			}
			else {
				if (value == null) {
					setCommunity(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("sex")) {
			if (value instanceof String) {
				setSex((String) value);
			}
			else {
				if (value == null) {
					setSex(null); //Luggi OBER - OBER - oberspezialitaet !
				}
			}
		}


		else if	(propertyName.equals("birthday")) {
			if (value instanceof java.util.Date) {
				setBirthday((java.util.Date) value);
			}
			else {
				if (value == null) {
					setBirthday(null);
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
						setBirthday(date);
						break;
					} catch (java.text.ParseException e) {
					log.debug("Couldn't parse date from string.", e);
					}
				}
			}
			}
		}


		else if	(propertyName.equals("armbrust")) {
			if (value instanceof java.lang.Boolean) {
				setArmbrust((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("gk")) {
			if (value instanceof java.lang.Boolean) {
				setGk((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("feuerstutzen")) {
			if (value instanceof java.lang.Boolean) {
				setFeuerstutzen((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("feuerpistole")) {
			if (value instanceof java.lang.Boolean) {
				setFeuerpistole((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("fp")) {
			if (value instanceof java.lang.Boolean) {
				setFp((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("kk")) {
			if (value instanceof java.lang.Boolean) {
				setKk((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("lg")) {
			if (value instanceof java.lang.Boolean) {
				setLg((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("lp")) {
			if (value instanceof java.lang.Boolean) {
				setLp((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("lp5")) {
			if (value instanceof java.lang.Boolean) {
				setLp5((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("vorderlader")) {
			if (value instanceof java.lang.Boolean) {
				setVorderlader((java.lang.Boolean) value);
			}
			else {
			}
		}


		else if	(propertyName.equals("zimmerstutzen")) {
			if (value instanceof java.lang.Boolean) {
				setZimmerstutzen((java.lang.Boolean) value);
			}
			else {
			}
		}

	}
	public Object getProperty(String propertyName) {
		if (propertyName.equals("id")) {
			return getId();
		}
		else if(propertyName.equals("signIn")) {
			return getSignIn();
		}
		else if(propertyName.equals("lastUpdate")) {
			return getLastUpdate();
		}
		else if(propertyName.equals("name")) {
			return getName();
		}
		else if(propertyName.equals("passNr")) {
			return getPassNr();
		}
		else if(propertyName.equals("community")) {
			return getCommunity();
		}
		else if(propertyName.equals("sex")) {
			return getSex();
		}
		else if(propertyName.equals("birthday")) {
			return getBirthday();
		}
		else if(propertyName.equals("armbrust")) {
			return isArmbrust();
		}
		else if(propertyName.equals("gk")) {
			return isGk();
		}
		else if(propertyName.equals("feuerstutzen")) {
			return isFeuerstutzen();
		}
		else if(propertyName.equals("feuerpistole")) {
			return isFeuerpistole();
		}
		else if(propertyName.equals("fp")) {
			return isFp();
		}
		else if(propertyName.equals("kk")) {
			return isKk();
		}
		else if(propertyName.equals("lg")) {
			return isLg();
		}
		else if(propertyName.equals("lp")) {
			return isLp();
		}
		else if(propertyName.equals("lp5")) {
			return isLp5();
		}
		else if(propertyName.equals("vorderlader")) {
			return isVorderlader();
		}
		else if(propertyName.equals("zimmerstutzen")) {
			return isZimmerstutzen();
		}
		return null;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
			if (!(obj instanceof at.co.schranz.tlsb.shooter.model.Shooter)) return false;
		else {
			at.co.schranz.tlsb.shooter.model.Shooter other = (at.co.schranz.tlsb.shooter.model.Shooter) obj;
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
