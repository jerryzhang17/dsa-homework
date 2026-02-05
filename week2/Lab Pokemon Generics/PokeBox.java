public class PokeBox {

    private Pokemon value;

    public PokeBox(Pokemon value) {
        this.value = value;
    }

    public Pokemon get() {
        return this.value;
    }

    public void set(Pokemon newValue) {
        this.value = newValue;
    }
}