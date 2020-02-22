/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @param array
 * @param target
 * @returns {boolean}
 * @constructor
 */
function Find(array, target) {
    if (array === null || array.length === 0 || array[0].length === 0)
        return false;
    let i = 0, j = array[0].length - 1;
    while (i <= array.length - 1 && j >= 0) {
        if (array[i][j] === target) {
            return true;
        } else if (array[i][j] < target) {
            i++
        } else {
            j--;
        }
    }
    return false;
}

Find([[1, 2, 8, 9], [4, 7, 10, 13]], 7)