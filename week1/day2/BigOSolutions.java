// function sumArray(arr) {
//   let sum = 0;
//   for (let i = 0; i < arr.length; i++) {
//     sum += arr[i];
//   }
//   return sum;
// }

// // What is the time complexity?
// // Your answer: O(?)
// // The time complexity of this function is O(n), as it's just one loop iterating through each element once and it varies on how many elemets aer there.

// function printPairs(arr) {
//   for (let i = 0; i < arr.length; i++) {
//     for (let j = 0; j < arr.length; j++) {
//       console.log(arr[i], arr[j]);
//     }
//   }
// }

// // What is the time complexity?
// // Your answer: O(?)
// // The time complexity of this function is O(n^2), with nested loops it will takes twice as long

// function compareLists(listA, listB) {
//   listA.forEach(a => {
//     console.log(a);
//   });
  
//   listB.forEach(b => {
//     console.log(b);
//   });
// }

// // What is the time complexity?
// // Your answer: O(?)
// // THe time complexity of this function is O(a + b), since the two variables are independent we add them.

// function processData(arr) {
//   // First loop: O(n)
//   arr.forEach(item => console.log(item));
  
//   // Nested loops: O(n²)
//   for (let i = 0; i < arr.length; i++) {
//     for (let j = 0; j < arr.length; j++) {
//       console.log(arr[i] + arr[j]);
//     }
//   }
// }

// // Initial complexity: O(n + n²)
// // Simplified: O(?)
// // This is O(n^2), we take the highest degree of time complexity.

// function createMatrix(n) {
//   const matrix = [];
  
//   for (let i = 0; i < n; i++) {
//     matrix[i] = [];
//     for (let j = 0; j < n; j++) {
//       matrix[i][j] = i * j;
//     }
//   }
  
//   return matrix;
// }

// // Time Complexity: O(?)
// // Space Complexity: O(?)
// // This is O(n^2) because of nested loops, and the space complexity is O(n^2) as well because of the two matrixes

// // Current: O(n²) - finds if array has duplicates
// function hasDuplicates(arr) {
//   for (let i = 0; i < arr.length; i++) {
//     for (let j = i + 1; j < arr.length; j++) {
//       if (arr[i] === arr[j]) {
//         return true;
//       }
//     }
//   }
//   return false;
// }

// // Optimize to O(n) using a Set or Object
// function hasDuplicatesOptimized(arr) {
//   // Your code here
// import java.util.HashSet;
// import java.util.Set;

// public class Main {
//     public boolean hasDuplicatesOptimized() {

//         Set<Integer> set = new HashSet<>();

//         for(int num : arr){
//             if(set.contains(num)){
//                 return true;
//             }
//             set.add(num);
//         }
//         return false;
//     }
// }

