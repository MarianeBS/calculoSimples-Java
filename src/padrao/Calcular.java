//Pacote respectivo do programa:
package padrao;

//Importação das bibliotecas referentes à interface JFrame:
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//Importação da biblioteca referente ao uso da forma decimal
//Apresentação dos resultados com números reduzidos após a vírgula:
import java.text.DecimalFormat;

//Classe "Calcular" que herdará os atributos e métodos da classe JFrame:       
public class Calcular extends JFrame 
{
    //Criando os rótulos de texto em seu respectivo tipo(Label):
    JLabel n1, n2, resultado;
    //Criando os campos de inserção de texto pelo usuário e
    //também, o campo de apresentação do resultado(TextField):
    JTextField txt1, txt2, txt3;
    //Criando alternativas para a escolha da operação desejada(RadioButton):
    JRadioButton somar, subtrair, multiplicar, dividir, resto;
    //Criando um grupo de botões para que seja possível apenas uma seleção 
    //por vez(ButtonGroup):
    ButtonGroup grupo1;
    //Criando o botão responsável para ação de calcular:
    JButton calcular;
    //Variável para formatar números em formato decimal:
    public DecimalFormat df = new DecimalFormat();
    
    //Método construtor:
    public Calcular()
    {
        //Título da parte superior da telinha
        super("Calculadora");
        //Criando o objeto tela:
        Container tela = getContentPane();
        //Posicionamento dos rótulos na tela 
        //(isso fará com que seus posicionamentos dependam do setBounds criado):
        setLayout(null);
        //Instância do label "n1" e do que ele deverá apresentar ao ser chamado:
        n1 = new JLabel("1º número:");
        //Instância do label "n2" e do que ele deverá apresentar ao ser chamado:
        n2 = new JLabel("2º número:");
        //Instância do label "resultado" e o que ele apresentará ao ser chamado:
        resultado = new JLabel ("Resultado:");
        //Instância do button e o que ele apresentará como rótulo do botão:
        calcular = new JButton ("Calcular");
        //Instância do radioButton somar e o que ele apresentará ao ser chamado:
        somar = new JRadioButton("Soma (+)");
        //Instância do rdBtn subtrair e o que ele apresentará ao ser chamado:
        subtrair = new JRadioButton("Subtração (-)");
        //Instância do rdBtn multiplicar e o que ele apresentará ao ser chamado:
        multiplicar = new JRadioButton("Multiplicação (x)");
        //Instância do rdBtn dividir e o que ele apresentará ao ser chamado:
        dividir = new JRadioButton("Divisão (/)");
        //Instância do rdBtn resto e o que ele apresentará ao ser chamado:
        resto = new JRadioButton("Resto (%)");
        //Instância do textField txt1 e o número de colunas do componente 
        //(irá apresentar 5 colunas de largura):
        txt1 = new JTextField(5);
        //Instância do textField txt2 e o número de colunas do componente:
        txt2 = new JTextField(5);
        //Instância do textField txt3 e o número de colunas do componente:
        txt3 = new JTextField(5);
        //Instância do buttonGroup grupo1:
        grupo1 = new ButtonGroup();
        //Adicionando ao grupo1 todos os radioButtons
        //(Com isto, será possível selecionar apenas um radioButton por vez):
        //Adicionando o rdBtn "somar":
        grupo1.add(somar);
        //Adicionando o rdBtn "subtrair":
        grupo1.add(subtrair);
        //Adicionando o rdBtn "multiplicar":
        grupo1.add(multiplicar);
        //Adicionando o rdBtn "dividir":
        grupo1.add(dividir);
        //Adicionando o rdBtn "resto":
        grupo1.add(resto);
        
        //Posicionamento dos componentes na tela:
        //(Os parâmetros do método setBounds são):
        //(int x, int y, int w, int h)
        //(int x -> eixo x -> posição horizontal)
        //(int y -> eixo y ->´posição vertical)
        //(int w -> width -> largura)
        //(int h -> height -> altura)   
        n1.setBounds(10, 20, 150, 20);
        txt1.setBounds(100, 20, 150, 20);
        n2.setBounds(10, 50, 150, 20);
        txt2.setBounds(100, 50, 150, 20);
        calcular.setBounds(150, 100, 100, 20);
        somar.setBounds(10, 100, 100, 20);
        subtrair.setBounds(10, 130, 180, 20);
        multiplicar.setBounds(10, 160, 180, 20);
        dividir.setBounds(10, 190, 180, 20);
        resto.setBounds(10, 220, 180, 20);
        resultado.setBounds(10, 270, 100, 20);
        txt3.setBounds(100, 270, 150, 20);
        
        //Definindo a fonte, o estado e o tamanho das letras dos componentes: 
        n1.setFont(new Font ("Arial", Font.BOLD, 16));
        n2.setFont(new Font ("Arial", Font.BOLD, 16));
        calcular.setFont(new Font ("Arial", Font.BOLD, 16));
        somar.setFont(new Font ("Arial", Font.BOLD, 16));
        subtrair.setFont(new Font ("Arial", Font.BOLD, 16));
        multiplicar.setFont(new Font ("Arial", Font.BOLD, 16));
        dividir.setFont(new Font ("Arial", Font.BOLD, 16));
        resto.setFont(new Font ("Arial", Font.BOLD, 16));
        resultado.setFont(new Font ("Arial", Font.BOLD, 16));
        
        //Atribuição de funcionalidade ao botão "calcular":
        calcular.addActionListener
        (
            new ActionListener()
            {
                //Método utilizado para "ouvir" ações realizadas no botão
                //Ação realizada -> clicar
                public void actionPerformed(ActionEvent e)
                {
                    //Atribuindo variáveis locais para realizar os cálculos:
                    double num1, num2, result;
                    //Atribuindo o valor inicial da variável "result":
                    result = 0.00;
                    //Convertendo para números decimais 
                    //o que foi inserido como string no txt1:
                    //após conversão, o dado será inserido em num1:
                    num1 = Double.parseDouble(txt1.getText());
                    //Convertendo para números decimais 
                    //o que foi inserido como string no txt2
                    //após conversão, o dado será inserido em num2:
                    num2 = Double.parseDouble(txt2.getText());
                    
                    //Atribuindo "true" ao setVisible, para que apresente o que
                    //será ordenado nas linhas a seguir:
                    txt3.setVisible(true);
                    
                    //Bloco condicional onde, a ação será definida 
                    //a partir da seleção de um dos radioButtons:
                    
                    //Condição:"Se a seleção do rdbtn somar estiver verdadeira,
                    //(ou seja, se o rdbtn somar for selecionado),
                    //o valor da variável resultado deve ser atribuído por
                    // num1 + num2":
                    if (somar.isSelected() == true)
                        result = num1 + num2;
                        //Setando o texto que foi definido para txt3
                        //para que ele apareça, juntamente com o resultado
                        //que está colocado em formato decimal:
                        txt3.setText(df.format(result));
                        
                    //Condição:"Se a seleção do rdbtn subtrair for verdadeira,
                    //o valor da variável resultado deve ser atribuído por
                    // num1 - num2":    
                    if (subtrair.isSelected() == true)
                        result = num1 - num2;
                        //Setando o texto que foi definido para txt3
                        //para que ele apareça, juntamente com o resultado
                        //que está colocado em formato decimal:
                        txt3.setText(df.format(result));
                        
                    //Condição:"Se a seleção do rdbtn multiplicar for verdadeira
                    //o valor da variável resultado deve ser atribuído por
                    // num1 x num2":       
                    if (multiplicar.isSelected() == true)
                        result = num1 * num2;
                        //Setando o texto que foi definido para txt3
                        //para que ele apareça, juntamente com o resultado
                        //que está colocado em formato decimal:
                        txt3.setText(df.format(result));
                        
                    //Condição:"Se a seleção do rdbtn dividir for verdadeira
                    //o valor da variável resultado deve ser atribuído por
                    // num1 / num2":     
                    if (dividir.isSelected() == true)
                        result = num1 / num2;
                        //Setando o texto que foi definido para txt3
                        //para que ele apareça, juntamente com o resultado
                        //que está colocado em formato decimal:
                        txt3.setText(df.format(result));
                        
                    //Condição:"Se a seleção do rdbtn resto for verdadeira
                    //o valor da variável resultado deve ser atribuído por
                    // num1 % num2"
                    //(aparecerá o que sobra da divisão entre o num1 e num2):    
                    if (resto.isSelected() == true)
                        result = num1 % num2;
                        //Setando o texto que foi definido para txt3
                        //para que ele apareça, juntamente com o resultado
                        //que está colocado em formato decimal:
                        txt3.setText(df.format(result));
                }   
            } 
        );
    
        //Adicionando os componentes à janela do programa:
        tela.add(n1);
        tela.add(txt1);
        tela.add(n2);
        tela.add(txt2);
        tela.add(calcular);
        tela.add(somar);
        tela.add(subtrair);
        tela.add(multiplicar);
        tela.add(dividir);
        tela.add(resto);
        tela.add(resultado);
        tela.add(txt3);
        
        //Atribuindo null ao modo relativo para que a janela do programa surja 
        //no centro da tela:
        setLocationRelativeTo(null);
        //Atribuindo false ao setResizable para que não seja possível 
        //redimencionar a janela do programa:
        setResizable(false);
        //Atribuindo tamanho da janela (x,y):
        setSize(300, 340);
        //Atribuindo visibilidade à tela:
        setVisible(true);
    }
}
