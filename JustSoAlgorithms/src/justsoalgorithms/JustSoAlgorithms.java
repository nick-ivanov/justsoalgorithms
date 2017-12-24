/*
    Just So Algorithms -- Pretty good implementation of common algorightms
    Copyright (C) 2017 Nick Ivanov

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package justsoalgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class JustSoAlgorithms {
    public static void main(String[] args) {
        System.out.println("=== Just So Algorithms ===");
        
        ArrayList<IAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new QuickSortAscent());
        
        
        for(int i = 0; i < algorithms.size(); i++) {
            System.out.println("" + (i + 1) + ": " + algorithms.get(i).description());
        }
        
        System.out.print("ALGORITHM NUMBER FROM THE LIST ABOVE: ");
        
        Scanner scanner = new Scanner(System.in);
        int algorithmNumber = scanner.nextInt();
        
        if(algorithmNumber < 1 || algorithmNumber > algorithms.size()) {
            System.out.println("ERROR: Wrong algorithm number.");
            return;
        }
        
        algorithms.get(algorithmNumber-1).go();  
    }
}
