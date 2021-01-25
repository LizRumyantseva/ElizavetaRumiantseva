package hw5.Services.Pages.Components.Items.items;

public enum HeaderMenuItems {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    private String itemName;
    HeaderMenuItems(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }

}
