package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.banco;
import modelo.periodos;
import modelo.permanencia;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;




public class resultado {

   
    public spacenet con;
    
    
    public periodos PesquisarPeriodo(int id_permanencia , String banco) throws SQLException, Exception {
             
        spacenet con = new spacenet();
        con.getConexao(banco);
        periodos valores = null;
        PreparedStatement pst = null;
        pst = con.dbConn.prepareStatement("select * from PERMANENCIA_ASA where id_permanencia = ?");        
        pst.setInt(1,id_permanencia);
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {   
            valores = new periodos();
            valores.setPeriodo_1_ini(rs.getString("PERIODO_1_INI"));
            valores.setPeriodo_1_fim(rs.getString("PERIODO_1_FIM"));
            
            valores.setPeriodo_2_ini(rs.getString("PERIODO_2_INI"));
            valores.setPeriodo_2_fim(rs.getString("PERIODO_2_FIM"));
            
            valores.setPeriodo_3_ini(rs.getString("PERIODO_3_INI"));
            valores.setPeriodo_3_fim(rs.getString("PERIODO_3_FIM"));
            
            valores.setPeriodo_4_ini(rs.getString("PERIODO_4_INI"));
            valores.setPeriodo_4_fim(rs.getString("PERIODO_4_FIM"));
            
            valores.setPeriodo_5_ini(rs.getString("PERIODO_5_INI"));
            valores.setPeriodo_5_fim(rs.getString("PERIODO_5_FIM"));
            
            valores.setPeriodo_6_ini(rs.getString("PERIODO_6_INI"));
            valores.setPeriodo_6_fim(rs.getString("PERIODO_6_FIM"));
            
            valores.setPeriodo_7_ini(rs.getString("PERIODO_7_INI"));
            valores.setPeriodo_7_fim(rs.getString("PERIODO_7_FIM"));
            
            valores.setPeriodo_8_ini(rs.getString("PERIODO_8_INI"));
            valores.setPeriodo_8_fim(rs.getString("PERIODO_8_FIM"));
            
            valores.setPeriodo_9_ini(rs.getString("PERIODO_9_INI"));
            valores.setPeriodo_9_fim(rs.getString("PERIODO_9_FIM"));
                      
        }
      return valores;
    }
    
    
    public periodos contaPeriodoInicio(String tipoPermanencia,String periodo_zero,String periodo_inicio,String banco) throws Exception
    {
        spacenet con = new spacenet();
        con.getConexao(banco);
        periodos valores2= null;
        Statement st0= con.dbConn.createStatement();
        st0.executeQuery("select DATEDIFF(second,'"+periodo_zero+"','"+periodo_inicio+"')"
        + "permanencia from PERMANENCIA_ASA where id_permanencia = "+tipoPermanencia+"");
        ResultSet conta = st0.getResultSet();
        while(conta.next())
        {
           valores2 = new periodos();   
           valores2.setPermanencia1(conta.getString("PERMANENCIA"));
           
        }
        return valores2;
    }
     public periodos contaPeriodoFinal(String tipoPermanencia,String periodo_zero,String periodo_final,String banco) throws Exception
    {
        spacenet con = new spacenet();
        con.getConexao(banco);
        periodos valores3= null;
        Statement st0= con.dbConn.createStatement();
        st0.executeQuery("select DATEDIFF(second,'"+periodo_zero+"','"+periodo_final+"')"
        + "permanencia from PERMANENCIA_ASA where id_permanencia = "+tipoPermanencia+"");
        ResultSet conta = st0.getResultSet();
        while(conta.next())
        {
           valores3 = new periodos();   
           valores3.setPermanencia2(conta.getString("PERMANENCIA"));
           
        }
        return valores3;
    }
      
        public periodos Resultado(String periodozero,String periodoTotal,String dataperiodoInicio,String dayChange,String dataperiodoFim,String banco) throws Exception
        {
        spacenet con = new spacenet();
        con.getConexao(banco);
        periodos valores1 = null;
        Statement st = con.dbConn.createStatement();
        st.executeQuery("select count(*)Periodo1 from SAIDA_NORMAL_AVULSO\n" +
        "where datediff(SECOND,DATA_ENTRADA,DATA_SAIDA)between "+periodozero+" "
                + "and "+periodoTotal+"and DATA_SAIDA between"
                +"'"+dataperiodoInicio+""+
                ""+" "+dayChange+"'"
                +"and"+"'"+dataperiodoFim+" "+" "+dayChange+"'");
        ResultSet rs = st.getResultSet();
        while(rs.next())
        {   
            valores1 = new periodos();
            valores1.setPeriodo1(rs.getString("PERIODO1"));
        }
            return valores1;
           
        }
         
         public ArrayList<banco> finAll()throws Exception{ // utilizado o metodo findAll() do array
        
        ArrayList<banco> lista = new ArrayList<>(); // Criado um ArrayList de ConfiguracaoBasica com o nome lista
        spacenet con1 = new spacenet();
        con1.getConexaoini();
        ResultSet rs = null; // Agrupa os Resultados da pesquisa
        Statement stm = null;// Variavel para utilizar comandos básicos
        
        try{
            stm = con1.dbConn.createStatement(); // Cria uma instancia do Statement
            rs = stm.executeQuery("SELECT name, database_id, create_date  \n" +
            "FROM sys.databases\n" +
            "where name like '%spacenet%' "); // o rs recebe os resultado da consulta do Statement com o metodo executeQuery;
            
            while(rs.next()) // foi criado um while para procurar todo os registros
            {
                banco bancoselect = new banco(); // foi criado um objeto configuraçãoBean
                bancoselect.setBancoDeDados(rs.getString("NAME")); // setado no Day_chango o valor pesquisado em rs.getString("Nome da coluna"); 
                lista.add(bancoselect); // adicionado toda a pesquisa na lista
    
            }
            return lista;
            
        }catch(SQLException ex)
        {
            System.out.println("Erro : " +ex.getMessage());
        }
      return null;
    }
         
   public permanencia GeraRelatorio(String SQL,String banco)
   {
       try{
           spacenet con = new spacenet();
           con.getConexao(banco);
           PreparedStatement smtp = con.dbConn.prepareStatement(SQL);
           ResultSet rs = smtp.executeQuery();
           JRResultSetDataSource relatorio = new JRResultSetDataSource(rs);
           JasperPrint print = JasperFillManager.fillReport("C:\\Relatorio_Permanencia\\Permanencia_Tipo.jasper"
           ,new HashMap(),relatorio);
           JasperViewer jv = new JasperViewer(print,false);
           jv.setVisible(true);
           jv.toFront();
           smtp.close();
       }catch(Exception Erro)
       {
           JOptionPane.showMessageDialog(null,"Erro ao Gerar Relatório !" + Erro.getMessage());
       }
       return null;
   }
   
         
}

  

     

