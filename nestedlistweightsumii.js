//Objective is similar to 'Nested List Weight Sum II', except with inverted depths.

let list = [[1,1],2,[1,1]]


//O(n) solution that finds the deepest depth first and then uses it to get the sum.g

function getSum(list, depth) {
    let sum = 0

    for (let element of list) {
        if (isFinite(element)) {
            sum += element * depth
        } else {
            sum += getSum(element, depth - 1)
        }
    }

    return sum
}

function getMaxDepth(list) {
    let depth = 0
    for (let element of list) {
        if (!isFinite(element)) {
            depth = Math.max(depth, getMaxDepth(element))
        }
    }

    return depth + 1
}

return getSum(list, getMaxDepth(list))