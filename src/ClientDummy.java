package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDummy
{
    public static void main(String[] args)
    {
        try
        {
            Socket s = new Socket("127.0.0.1", 8080);

            while(true)
            {

                InputStream input = s.getInputStream();
                OutputStream output = s.getOutputStream();

                Scanner in = new Scanner(input);
                // Når vi skriver til output streamen bruger vi her en PrintWriter.
                PrintWriter out = new PrintWriter(output, true);
                // Modtag velkomst
                String welcome = in.nextLine();

             //   System.out.println(welcome);

                // Nu kan vi så sende og modtage respektivt
                out.println("NAME: Noah");
                // Vi udskriver nu bare direkte
                System.out.println("Svar fra svr: " + in.nextLine());

                out.println("PUT: Goddag");
                // Vi udskriver nu bare direkte
                System.out.println("Svar fra svr: " + in.nextLine());

                out.println("COUNT");
                // Vi udskriver nu bare direkte
                System.out.println("Svar fra svr: " + in.nextLine());
                System.out.println("Antal fra svr: " + in.nextLine());

                out.println("GET: 1");
                // Vi udskriver nu bare direkte
                System.out.println("Svar fra svr: " + in.nextLine());

                out.println("Error");
                // Vi udskriver nu bare direkte
                System.out.println(in.nextLine());

                // Denne gang lukker vi selv forbindelsen. Fordi vi kan.
                // Vi kunne også have brugt "luk ned"
                s.close();
                System.out.println("Forbindelsen lukket.");
            }
        }
        catch (IOException ex)
        {

        }
    }
}