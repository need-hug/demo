package com.soft.demo.test;

/*	Program to create "Time-Lock Puzzle" for LCS35 Time Capsule
	Ronald L. Rivest
	April 2, 1999
 */

import java.io.*;
import java.math.BigInteger;

/**
 * address: https://people.csail.mit.edu/rivest/lcs35-puzzle-description.txt
 * https://blog.csdn.net/Blockchain_lemon/article/details/89944002
 */
public class TimeLockPuzzle {

    BigInteger n = new BigInteger(
            "631446608307288889379935712613129233236329881833084137558899" +
            "077270195712892488554730844605575320651361834662884894808866" +
            "350036848039658817136198766052189726781016228055747539383830" +
            "826175971321892666861177695452639157012069093997368008972127" +
            "446466642331918780683055206795125307008202024124623398241073" +
            "775370512734449416950118097524189066796385875485631980550727" +
            "370990439711973361466670154390536015254337398252457931357531" +
            "765364633198906465140213398526580034199190398219284471021246" +
            "488745938885358207031808428902320971090703239693491996277899" +
            "532332018406452247646396635593736700936921275809208629319872" +
            "7008292431243681");

    BigInteger t = new BigInteger("79685186856218");

    BigInteger z = new BigInteger(
            "427338526681239414707099486152541907807623930474842759553127" +
            "699575212802021361367225451651600353733949495680760238284875" +
            "258690199022379638588291839885522498545851997481849074579523" +
            "880422628363751913235562086585480775061024927773968205036369" +
            "669785002263076319003533000450157772067087172252728016627835" +
            "400463807389033342175518988780339070669313124967596962087173" +
            "533318107116757443584187074039849389081123568362582652760250" +
            "029401090870231288509578454981440888629750522601069337564316" +
            "940360631375375394366442662022050529545706707758321979377282" +
            "989361374561414204719371297211725179287931039547753581030226" +
            "7611143659071382");

    public TimeLockPuzzle () {}

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static public void main(String args[]) throws IOException {
        System.out.println("Creating LCS35 Time Capsule Crypto-Puzzle...");
        CreatePuzzle();
        System.out.println("Puzzle Created.");
    }

    static public void CreatePuzzle() throws IOException {
        // Compute count of squarings to do each year
        BigInteger squaringsPerSecond = new BigInteger("3000"); // in 1999
        System.out.println("Assumed number of squarings/second (now) = "+
                squaringsPerSecond);
        BigInteger secondsPerYear = new BigInteger("31536000");
        BigInteger squaringsFirstYear = secondsPerYear.multiply(squaringsPerSecond);
        System.out.println("Squarings (first year) = "+squaringsFirstYear);
        int years = 35;
        BigInteger t = new BigInteger("0");
        BigInteger s = squaringsFirstYear;
        for (int i = 1999;i<=1998+years;i++)
        {   // do s squarings in year i
            t = t.add(s);
            // apply Moore's Law to get number of squarings to do the next year
            String growth = new String("");
            growth = "12204";             // ~x13 up to 2012, at constant rate
            if (i>2012) growth = "10750"; // ~x5  up to 2034, at constant rate
            s = s.multiply(new BigInteger(growth)).divide(new BigInteger("10000"));
        }
        System.out.println("Squarings (total)= "  + t);
        System.out.println("Ratio of total to first year = "+
                t.divide(squaringsFirstYear));
        System.out.println("Ratio of last year to first year = "+
                s.divide(squaringsFirstYear.multiply(new BigInteger("10758"))
                        .divide(new BigInteger("10000"))));

        // Now generate RSA parameters
        int primelength = 1024;
        System.out.println("Using "+primelength+"-bit primes.");
        BigInteger twoPower = (new BigInteger("1")).shiftLeft(primelength);

        String pseed = getString("large random integer for prime p seed");
        BigInteger prand = new BigInteger(pseed);
        String qseed = getString("large random integer for prime q seed");
        BigInteger qrand = new BigInteger(qseed);
        System.out.println("Computing...");

        BigInteger p = new BigInteger("5");
        // Note that 5 has maximal order modulo 2^k (See Knuth)
        p = getNextPrime(p.modPow(prand,twoPower));
        System.out.println("p = "+p);

        BigInteger q = new BigInteger("5");
        q = getNextPrime(q.modPow(qrand,twoPower));
        System.out.println("q = "+q);

        BigInteger n = p.multiply(q);
        System.out.println("n = "+n);

        BigInteger pm1 = p.subtract(ONE);
        BigInteger qm1 = q.subtract(ONE);
        BigInteger phi = pm1.multiply(qm1);
        System.out.println("phi = "+phi);

        // Now generate final puzzle value w
        BigInteger u = TWO.modPow(t,phi);
        BigInteger w = TWO.modPow(u,n);
        System.out.println("w (hex) = "+w.toString(16));

        // Obtain and encrypt the secret message
        // Include seed for p as a check
        StringBuffer sgen = new StringBuffer(getString("string for secret"));
        sgen = sgen.append(" (seed value b for p = "+prand.toString()+")");
        System.out.println("Puzzle secret = "+sgen);
        BigInteger secret = getBigIntegerFromStringBuffer(sgen);
        if (secret.compareTo(n) > 0)
        { System.out.println("Secret too large!"); return; }
        BigInteger z = secret.xor(w);
        System.out.println("z(hex) = "+z.toString(16));

        // Write output to a file
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\puzzleoutput.txt"));
        pw.println("Crypto-Puzzle for LCS35 Time Capsule.");
        pw.println("Created by Ronald L. Rivest. April 2, 1999."); pw.println();
        pw.println("Puzzle parameters (all in decimal):"); pw.println();
        pw.print("n = "); printBigInteger(n,pw); pw.println();
        pw.print("t = "); printBigInteger(t,pw); pw.println();
        pw.print("z = "); printBigInteger(z,pw); pw.println();
        pw.println("To solve the puzzle, first compute w = 2^(2^t) (mod n).");
        pw.println("Then exclusive-or the result with z.");
        pw.println("(Right-justify the two strings first.)");
        pw.println();
        pw.println("The result is the secret message (8 bits per character),");
        pw.println("including information that will allow you to factor n.");
        pw.println("(The extra information is a seed value b, such that ");
        pw.println("5^b (mod 2^1024) is just below a prime factor of n.)");
        pw.println(" ");
        pw.close();

        // Wait for input carriage return to pause before closing
        System.in.read();
    }

    final static BigInteger ONE = new BigInteger("1");
    final static BigInteger TWO = new BigInteger("2");

    static String getString(String what) throws IOException {
        // This routine is essentially a prompted "readLine"
        StringBuffer s = new StringBuffer();
        System.out.println("Enter "+what+" followed by a carriage return:");
        for (int i = 0;i<1000;i++)
        { int c = System.in.read();
            if (c<0 || c == '\n') break;
            if (c != '\r') // note: ignore cr before newline
                s = s.append((char)c);
        }
        return(s.toString());
    }

    static BigInteger getBigIntegerFromStringBuffer(StringBuffer s)
            throws IOException {
        // Base-256 interpretation of the given string
        BigInteger randbi = new BigInteger("0");
        for (int i = 0;i<s.length();i++)
        {   int c = s.charAt(i);
            randbi = randbi.shiftLeft(8).add(new BigInteger(Integer.toString(c)));
        }
        System.out.println("Value of string entered (hex) = "+randbi.toString(16));
        return randbi;
    }

    static void printBigInteger (BigInteger x, PrintWriter pw) {
        String s = x.toString();
        int charsPerLine = 60;
        for (int i = 0;i<s.length();i+=charsPerLine)
        {   if (i!=0) { pw.println(); pw.print("    "); }
            pw.print(s.substring(i,java.lang.Math.min(i+charsPerLine,s.length())));
        }
        pw.println();
    }

    static BigInteger getNextPrime(BigInteger startvalue)
    {
        BigInteger p = startvalue;
        if (!p.and(ONE).equals(ONE))   p = p.add(ONE);
        while (!p.isProbablePrime(40)) p = p.add(TWO);
        return(p);
    }

}// end of TimeLockPuzzle class