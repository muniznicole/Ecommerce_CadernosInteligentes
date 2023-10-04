package br.unitins.hello.dto;

public class ItemDTO {

    private final String nomeItem;
    private final String descricaoItem;
    private final double precoItem;
    private final String imagemItem;

    public ItemDTO(String nomeItem, String descricaoItem, double precoItem, String imagemItem) {
        this.nomeItem = nomeItem;
        this.descricaoItem = descricaoItem;
        this.precoItem = precoItem;
        this.imagemItem = imagemItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public String getImagemItem() {
        return imagemItem;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
        result = prime * result + ((descricaoItem == null) ? 0 : descricaoItem.hashCode());
        result = prime * result + Double.hashCode(precoItem);
        result = prime * result + ((imagemItem == null) ? 0 : imagemItem.hashCode());

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
        ItemDTO other = (ItemDTO) obj;
        if (nomeItem == null) {
            if (other.nomeItem != null)
                return false;
        } else if (!nomeItem.equals(other.nomeItem))
            return false;
        if (descricaoItem == null) {
            if (other.descricaoItem != null)
                return false;
        } else if (!descricaoItem.equals(other.descricaoItem))
            return false;
        if (Double.compare(precoItem, other.precoItem) != 0)
            return false;
        if (imagemItem == null) {
            if (other.imagemItem != null)
                return false;
        } else if (!imagemItem.equals(other.imagemItem))
            return false;            
        return true;
    
    }

}
