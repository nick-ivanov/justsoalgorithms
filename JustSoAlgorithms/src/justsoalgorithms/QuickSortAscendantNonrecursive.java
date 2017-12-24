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

import java.util.Scanner;
import java.util.Stack;

public class QuickSortAscendantNonrecursive implements IAlgorithm {

    @Override
    public void go() {
	Scanner scanner = new Scanner(System.in);

	System.out.print("NUMBER OF ITEMS: ");
	int n = scanner.nextInt();

	int array[] = new int[n];

	for (int i = 0; i < n; i++) {
	    System.out.print("INTEGER ARRAY[" + i + "]: ");
	    array[i] = scanner.nextInt();
	}

	System.out.println("== UNSORTED ARRAY ==");

	for (int i = 0; i < n; i++) {
	    System.out.println("ARRAY[" + i + "]: " + array[i]);
	}

	quickSortAscend(array);

	System.out.println("== SORTED ARRAY (QUICKSORT ASCENDANT NONRECURSIVE) ==");

	for (int i = 0; i < n; i++) {
	    System.out.println("ARRAY[" + i + "]: " + array[i]);
	}
    }

    private void quickSortAscend(int array[]) {
	Stack<Integer> starts = new Stack<>();
	Stack<Integer> ends = new Stack<>();
	
	starts.push(0);
	ends.push(array.length-1);

	while (true) {
	    if(starts.isEmpty()) {
		return;
	    }
	    
	    int start = starts.pop();
	    int end = ends.pop();
	    
	    if (start >= end) {
		return;
	    }

	    int midIndex = (start + end) / 2;
	    int midValue = array[midIndex];
	    int west = start, east = end;

	    while (west <= east) {
		while (array[west] < midValue) {
		    west++;
		}

		while (array[east] > midValue) {
		    east--;
		}

		if (west <= east) {
		    int tmp = array[west];
		    array[west] = array[east];
		    array[east] = tmp;
		    west++;
		    east--;
		}
	    }

	    if(starts.isEmpty()) {
		if (west < end) {
		    starts.push(west);
		    ends.push(end);
		}

		if (east > start) {
		    starts.push(start);
		    ends.push(east);
		}
	    }

	}
    }

    @Override
    public String description() {
	return "Quick Search, Ascendant Order, Nonrecursive";
    }
}
