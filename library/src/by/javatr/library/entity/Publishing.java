package by.javatr.library.entity;

public class Publishing implements Cloneable {
    private long idPublishing;
    private String namePublishing;
    private String countryPublishing;

    public Publishing() {
    }

    public Publishing(long idPublishing, String namePublishing, String countryPublishing) {
        this.idPublishing = idPublishing;
        this.namePublishing = namePublishing;
        this.countryPublishing = countryPublishing;
    }

    public long getIdPublishing() {
        return idPublishing;
    }

    public void setIdPublishing(long idPublishing) {
        this.idPublishing = idPublishing;
    }

    public String getNamePublishing() {
        return namePublishing;
    }

    public void setNamePublishing(String namePublishing) {
        this.namePublishing = namePublishing;
    }

    public String getCountryPublishing() {
        return countryPublishing;
    }

    public void setCountryPublishing(String countryPublishing) {
        this.countryPublishing = countryPublishing;
    }

    @Override
    public Publishing clone() throws CloneNotSupportedException {
        Publishing clone = (Publishing) super.clone();

        return clone;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = (int) (idPublishing + (namePublishing == null ? 0 : namePublishing.hashCode()));
        result = result * prime + (countryPublishing == null ? 0 : countryPublishing.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Publishing tmp = (Publishing) obj;

        if (idPublishing != tmp.idPublishing)
            return false;
        if (namePublishing == null){
            if (tmp.namePublishing != null)
                return false;
        }else if (!namePublishing.equals(tmp.namePublishing)){
            return false;
        }
        if (countryPublishing == null){
            if (tmp.countryPublishing != null)
                return false;
        }else if (!countryPublishing.equals(tmp.countryPublishing)){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[".concat(getClass().getSimpleName()).concat(" - "));
        if (namePublishing != null || namePublishing.isEmpty()){
            sb.append("id : ".concat(String.valueOf(idPublishing)).concat(", publishing name : ").concat(namePublishing).concat(", country publishing : ").concat(countryPublishing));
        }else{
            sb.append(getClass().getName().concat(" - empty"));
        }

        sb.append("]");

        return sb.toString();
    }
}
