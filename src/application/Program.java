/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o caminho: ");
        String caminho = sc.nextLine();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
            
            Set<Log> set = new HashSet<>();
            String linha = br.readLine();
            
            while (linha != null) {                
                String[] vetor = linha.split(" ");
                String nome = vetor[0];
                Date momento = Date.from(Instant.parse(vetor[1]));
                
                set.add(new Log(nome, momento));
                
                linha = br.readLine();
            }
            System.out.print("Total de usuarios: "+set.size());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
    
}
