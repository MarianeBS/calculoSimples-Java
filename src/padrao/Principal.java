//Pacote respectivo do programa:
package padrao;

//Importação de bibliotca referente à interface JFrame:
import javax.swing.JFrame;

//Classe "Principal" que tem em si as principais ações do programa:
public class Principal 
{
    //Método principal, responsável pela execução 
    //e chamamento das outras classes do programa:
    public static void main(String[] args) 
    {
        //Instância da Classe calcular para um objeto de mesmo nome:
        Calcular calcular = new Calcular();
        //Chamando o programa para ser apresentado:
        calcular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}
