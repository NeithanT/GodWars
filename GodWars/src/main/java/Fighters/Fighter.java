package Fighters;


public abstract class Fighter {
    
    FighterType type;
    int strength;
    int endurance;
    int sanity;
    
    public abstract void normalAttack();
    public abstract void specialAttack();
    
}
