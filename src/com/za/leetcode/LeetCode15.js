var threeSum = function (arr) {
    var result = [];
    var nums = arr.sort();
    console.log(nums);
    for (var i = 0; i < nums.length - 1; i++) {
        if (nums[i] > 0) break;
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        var L = i + 1;
        var R = nums.length - 1;
        while (L < R) {
            var sum = nums[i] + nums[L] + nums[R];
            console.log('i,num[i]=' + i + ',' + nums[i] + '/L,num[L]=' + L + ',' + nums[L] + '/R,num[R]=' + R + ',' + nums[R] + '/sum=' + sum);
            if (sum === 0) {
                result.push([nums[i], nums[L], nums[R]]);
                console.log(result);
                while (L < R && nums[L] === nums[L + 1]) L++;
                while (L < R && nums[R] === nums[R + 1]) R--;
                R--;
                L++;
            } else if (sum > 0) {
                R--;
            } else if (sum < 0) {
                L++;
            }
        }
    }
    return result;
};

threeSum([-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]);