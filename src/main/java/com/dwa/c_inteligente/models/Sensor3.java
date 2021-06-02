// Generated with g9.

package com.dwa.c_inteligente.models;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sensor3")
public class Sensor3 implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(precision=10)
    private int tcorporal;
    @Column(precision=10)
    private int tambiente;
    @Column(length=10)
    private String fecha;

    /** Default constructor. */
    public Sensor3() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for tcorporal.
     *
     * @return the current value of tcorporal
     */
    public int getTcorporal() {
        return tcorporal;
    }

    /**
     * Setter method for tcorporal.
     *
     * @param aTcorporal the new value for tcorporal
     */
    public void setTcorporal(int aTcorporal) {
        tcorporal = aTcorporal;
    }

    /**
     * Access method for tambiente.
     *
     * @return the current value of tambiente
     */
    public int getTambiente() {
        return tambiente;
    }

    /**
     * Setter method for tambiente.
     *
     * @param aTambiente the new value for tambiente
     */
    public void setTambiente(int aTambiente) {
        tambiente = aTambiente;
    }

    /**
     * Access method for fecha.
     *
     * @return the current value of fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Setter method for fecha.
     *
     * @param aFecha the new value for fecha
     */
    public void setFecha(String aFecha) {
        fecha = aFecha;
    }

    /**
     * Compares the key for this instance with another Sensor3.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Sensor3 and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Sensor3)) {
            return false;
        }
        Sensor3 that = (Sensor3) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Sensor3.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Sensor3)) return false;
        return this.equalKeys(other) && ((Sensor3)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Sensor3 |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
