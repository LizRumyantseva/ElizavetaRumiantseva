package hw5.Services.Pages.Components.Items.items;

public enum LeftSideMenuItems {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements packs");

    private String itemName;
    LeftSideMenuItems(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }



}
