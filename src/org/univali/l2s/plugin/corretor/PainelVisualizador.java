/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.univali.l2s.plugin.corretor;

import br.univali.portugol.corretor.dinamico.CasoFalho;
import br.univali.portugol.corretor.dinamico.model.Caso;
import br.univali.portugol.corretor.dinamico.model.Entrada;
import br.univali.portugol.corretor.dinamico.model.Saida;
import br.univali.portugol.corretor.utils.MensagemCorretorEstatico;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Andrei
 */
public class PainelVisualizador extends javax.swing.JPanel {
    
    private List<MensagemCorretorEstatico> mensagensDoEstatico;
    private List<Caso> casosCorretos;
    private List<CasoFalho> casosErrados;
    
    public PainelVisualizador(List<MensagemCorretorEstatico> mensagensDoEstatico, List<Caso> casosCorretos, List<CasoFalho> casosErrados) {
        
        this.mensagensDoEstatico = mensagensDoEstatico;
        this.casosCorretos = casosCorretos;
        this.casosErrados = casosErrados;
        
        initComponents();
        
        exibeMensagens();
        
        exibeCasos();
        
    }
    
    private void exibeMensagens() {
        painelDicas.setLayout(new GridLayout(mensagensDoEstatico.size(), 1));
        for(MensagemCorretorEstatico mensagem : mensagensDoEstatico){
            JPanel painel = new JPanel(new FlowLayout());
            JLabel msg = new JLabel(mensagem.getMensagem());
            painel.add(msg);
            painelDicas.add(painel);
        }
    }
    
    private void exibeCasos(){
        
        DefaultMutableTreeNode casos = new DefaultMutableTreeNode("Casos");

        DefaultMutableTreeNode corretos = new DefaultMutableTreeNode("Corretos");
        
        casos.add(corretos);
        
        int i = 1;
        
        for(Caso caso: casosCorretos){
            DefaultMutableTreeNode no = new DefaultMutableTreeNode("Caso "+i);
            DefaultMutableTreeNode entradas = new DefaultMutableTreeNode("Entradas");    
            DefaultMutableTreeNode saidas = new DefaultMutableTreeNode("Saidas");
            
            for(Entrada entrada : caso.getEntradas()){
                entradas.add(new DefaultMutableTreeNode("("+entrada.getTipodado()+")" + " " + entrada.getValor()));
            }
            
            for(Saida saida : caso.getSaidas()){
                saidas.add(new DefaultMutableTreeNode("("+saida.getTipodado()+")" + " " + saida.getValor()));
            }
            
            no.add(entradas);
            no.add(saidas);
            corretos.add(no);
            
            i++;
        }
        
        DefaultMutableTreeNode errados = new DefaultMutableTreeNode("Errados");

        for(CasoFalho caso: casosErrados){
            DefaultMutableTreeNode no = new DefaultMutableTreeNode("Caso "+i);
            DefaultMutableTreeNode entradas = new DefaultMutableTreeNode("Entradas");    
            DefaultMutableTreeNode saidas = new DefaultMutableTreeNode("Saidas");

            for(Entrada entrada : caso.getCasoTestado().getEntradas()){
                entradas.add(new DefaultMutableTreeNode("("+entrada.getTipodado()+")" + " " + entrada.getValor()));
            }
            
            for(Saida saida : caso.getSaidaEncontrada()){
                saidas.add(new DefaultMutableTreeNode("("+saida.getTipodado()+")" + " " + saida.getValor()));
            }
            
            no.add(entradas);
            no.add(saidas);
            errados.add(no);
            
            i++;
        }
        
        casos.add(errados);
        
        arvoreCasos.setModel(new DefaultTreeModel(casos));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        arvoreCasos = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        painelDicas = new javax.swing.JPanel();

        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText("Dicas:");

        jLabel2.setText("Casos de Testes:");

        jScrollPane2.setViewportView(arvoreCasos);

        jScrollPane3.setBorder(null);
        jScrollPane3.setViewportView(painelDicas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(98, 365, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arvoreCasos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel painelDicas;
    // End of variables declaration//GEN-END:variables

}