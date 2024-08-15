/**
 * https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
 *
 * Approach 1: Divide array into n/k parts and use these subarrays as individual stacks and perform required operation.
 * Not efficient as one stack might be occupied but still other stack having empty space
 *
 */



/**
 * Approach 2:
 *
 * 1. Find free spot i.e. index available for use
 * 2. Update value of freespot
 * 3. Insert element in the array
 * 4. Update next
 * 5. Update top
 */
