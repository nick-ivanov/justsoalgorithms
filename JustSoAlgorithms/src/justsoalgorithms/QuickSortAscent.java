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

public class QuickSortAscent implements IAlgorithm {

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

	quickSortAscend(array, 0, array.length - 1);

	System.out.println("== SORTED ARRAY (QUICKSORT ASCENT) ==");

	for (int i = 0; i < n; i++) {
	    System.out.println("ARRAY[" + i + "]: " + array[i]);
	}
    }

    private void quickSortAscend(int array[], int start, int end) {
	if (start >= end) {
	    return;
	}

	int dividingIndex = start + ((end - start) / 2);
	int dividingValue = array[dividingIndex];
	int leftIndex = start, rightIndex = end;

	while (leftIndex <= rightIndex) {
	    while (array[leftIndex] < dividingValue) {
		leftIndex++;
	    }

	    while (array[rightIndex] > dividingValue) {
		rightIndex--;
	    }

	    if (leftIndex <= rightIndex) {
		int tmp = array[rightIndex];
		array[rightIndex] = array[leftIndex];
		array[leftIndex] = tmp;
		leftIndex++;
		rightIndex--;
	    }
	}

	if (rightIndex > start) {
	    quickSortAscend(array, start, rightIndex);
	}
	if (leftIndex < end) {
	    quickSortAscend(array, leftIndex, end);
	}
    }

    @Override
    public String description() {
	return "Quick Search, Ascent Order";
    }
}
