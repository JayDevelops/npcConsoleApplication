package hw03;

public class NpcMain {
    public static void main(String[] args) {
        //  Npc dialogue
        String[][] npcDialogue = new String[][] {
                {
                        "You have no wish to attack me, you think you do.",
                        "No way I am going to fight you, you're not worth it",
                        "So you insist? Well then...",
                        "I have no choice but to, but to...",
                        "Use my double sword skill 'Star Burst'!!!"
                },
                {
                        "Will you like some lamb chops?",
                        "I love steak sandwiches, they are my favorite in this world",
                        "Sometimes I wonder when we will get out of here, maybe one day?",
                        "Flying with your wings is the best feeling in this world",
                        "This world is finite but we make the best of it."
                }
        };


        //  Initialize the objects below
        Npc firstNpc = new Npc();
        Npc secondNpc = new Npc("Kirito", "Level 60 Human", 20, 10,  npcDialogue[0], true);
        Npc thirdNpc = new Npc("Asuna", "Level 40 Witch", 20, 10,  npcDialogue[1], false);


        //  You can add more objects to the arrNpc using append method and the menu will be updated accordingly
        Npc[] arrNpc = new Npc[] { firstNpc, secondNpc, thirdNpc };


        //  Create a new menu and run the menu with the passed array of npc objects
        Menu newMenu = new Menu(arrNpc);
        newMenu.runMenu();
    }

}
