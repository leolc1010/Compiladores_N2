package main;
import java.text.StringCharacterIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Stack;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static String RecebeTxt()
    {
        Scanner texto = new Scanner(System.in);

        String codigo1 = "";

        codigo1 = texto.next();

        return codigo1;
        
    }
    
    public static String RecebeOpcao()
    {
        Scanner texto1 = new Scanner(System.in);

        String codigo1 = "";

        codigo1 = texto1.next();

        return codigo1;
        
    }  

    public static Boolean ValidaFechamentos(String txt)
    {
        Stack<Character> pilha = new Stack<Character>();

        for(int i = 0; i < txt.length(); i++)
        {
            if (txt.charAt(i) == '<' ||  txt.charAt(i) == '{' || txt.charAt(i) == '[' || txt.charAt(i) == '(')
            {
               pilha.add(txt.charAt(i));
            }
            else if (txt.charAt(i) == '>')
            {
                if(pilha.peek() == '<')
                {
                    pilha.pop();
                }
                else
                {
                    return false;
                }
            }
            else if (txt.charAt(i) == '}')
            {
                if(pilha.peek() == '{')
                {
                    pilha.pop();
                }
                else
                {
                    return false;
                }
            }
            else if (txt.charAt(i) == ']')
            {
                if(pilha.peek() == '[')
                {
                    pilha.pop();
                }
                else
                {
                    return false;
                }
            }
            else if (txt.charAt(i) == ')')
            {
                if(pilha.peek() == '(')
                {
                    pilha.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        if(pilha.empty())
        {
            return true;
        }
        else
        return false;
        
    }

    public static Boolean ValidaAlfabeto(String txt)
    {
            char alfabeto[] = new char[8];

            alfabeto[0] = '<';

            alfabeto[1] = '{';

            alfabeto[2] = '[';

            alfabeto[3] = '(';

            alfabeto[4] = ')';

            alfabeto[5] = ']';

            alfabeto[6] = '}';

            alfabeto[7] = '>';

            int Cont = 0;

        do
        {
            if((txt.charAt(Cont)) != alfabeto[0] &&  (txt.charAt(Cont)) !=  alfabeto[1] &&  (txt.charAt(Cont)) !=  alfabeto[2]
                                       &&  (txt.charAt(Cont)) !=  alfabeto[3] &&  (txt.charAt(Cont)) !=  alfabeto[4]
                                       &&  (txt.charAt(Cont)) !=  alfabeto[5] &&  (txt.charAt(Cont)) !=  alfabeto[6]
                                       &&  (txt.charAt(Cont)) !=  alfabeto[7])
            {
                return false;
            }
            Cont = Cont + 1;

        }while(Cont < txt.length());

            return true;
    }

    public static Boolean ValidaTxt(String txt)
    {

        if (txt.length() % 2 > 0)
        {
            return false;
        }

        else if(ValidaAlfabeto(txt) == false)
        {
            return false;
        }

        else if(ValidaFechamentos(txt) == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static void main(String[] args) {

        

        String codigo = "";
        Boolean ok = true;
        String acao = "1";

        System.out.println("Bem vindo, Por favor insira sua linha de códigos e verifique se ela é válida");
        System.out.println(" apenas são aceitos os seguintes caracteres: <{[( )]}>");

        codigo = RecebeTxt();

        ok = ValidaTxt(codigo);

        if(ok == false)
        {
            System.out.println("O valor digitado não é válido");
        }

        else if(ok == true)
        {
            System.out.println("O valor digitado é válido");
        }

        do
        {
            System.out.println("Quer testar novamente? Digite 1 para sim ; Outro valor pra não");

            acao = RecebeOpcao();

            if(!(acao.contentEquals("1")))
            {
                break;
            }

                System.out.println("Insira o código, apenas são aceitos os seguintes caracteres: <{[( )]}>");
                codigo = RecebeTxt();

                ok = ValidaTxt(codigo);

                if(ok == false)
                 {
                    System.out.println("O valor digitado não é válido");
                 }

                else if(ok == true)
                {
                    System.out.println("O valor digitado é válido");
                }
            
        }while(true);

        System.out.println("Obrigado por utilizar o progama, até a próxima :)");
    
    }
}
