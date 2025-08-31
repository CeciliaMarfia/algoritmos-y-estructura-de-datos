package tp1.ejercicio9;

public class TestBalanceo {
	public static boolean estaBalanceado(String s) {
        Stack<Character> pila = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false; // Hay un cierre sin su correspondiente apertura
                }
                char top = pila.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // Los símbolos no coinciden
                }
            }
        }

        return pila.isEmpty(); // La pila debe estar vacía al final para que esté balanceado
    }

    public static void main(String[] args) {
        String prueba1 = "{( ) [ ( ) ] }";
        String prueba2 = "( [ ) ]";

        System.out.println("¿La prueba 1 está balanceada? " + estaBalanceado(prueba1));
        System.out.println("¿La prueba 2 está balanceada? " + estaBalanceado(prueba2));
    }
}
