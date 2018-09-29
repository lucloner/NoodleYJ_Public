/*eslint valid-jsdoc: "error"*/
/*eslint-env es6*/

/**
 * 分页函数
 * pno--页数
 * psize--每页显示记录数
 * 分页部分是从真实数据行开始，因而存在加减某个常数，以确定真正的记录数
 * 纯js分页实质是数据行全部加载，通过是否显示属性完成分页功能
 * @idData {string}
 * @pno {number}
 * @psize {number}
 * @returns {void}
 */
function goPage(idData, pno, psize) {
    var itable = document.getElementById(idData);
    var thisTop = $("#" + idData).offset().top;
    //alert(itable.innerHTML);
    var num = itable.rows.length;//表格所有行数(所有记录数)
    var true_num = num - parseInt(num / 31)-1;
    //console.log(num);
    var totalPage = 0;//总页数
    var pageSize = psize;//每页显示行数
    //总共分几页 
    if (num / pageSize > parseInt(num / pageSize)) {
        totalPage = parseInt(num / pageSize) + 1;
    } else {
        totalPage = parseInt(num / pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize + 1;//开始显示的行  32 
    var endRow = currentPage * pageSize;//结束显示的行   36
    endRow = (endRow > num) ? num : endRow; 40
    //console.log(endRow);
    //遍历显示数据实现分页
    for (var i = 1; i < (num + 1); i++) {
        var irow = itable.rows[i - 1];
        if (i >= startRow && i <= endRow) {
            irow.style.display = "block";
        } else {
            irow.style.display = "none";
        }
    }
    var pageEnd = document.getElementById(idData + "pageEnd");
    var tempStr = "共" + true_num + "条记录 分" + totalPage + "页 当前第" + currentPage + "页";
    if (currentPage > 1) {
        tempStr += "<a href=\"#\" onClick=\"goPage('" + idData + "'," + (1) + "," + psize + ")\">首页</a>";
        tempStr += "<a href=\"#\" onClick=\"goPage('" + idData + "'," + (currentPage - 1) + "," + psize + ")\"><上一页</a>"
    } else {
        tempStr += "首页";
        tempStr += "<上一页";
    }

    if (currentPage < totalPage) {
        tempStr += "<a href=\"#\" onClick=\"goPage('" + idData + "'," + (currentPage + 1) + "," + psize + ")\">下一页></a>";
        tempStr += "<a href=\"#\" onClick=\"goPage('" + idData + "'," + (totalPage) + "," + psize + ")\">尾页</a>";
    } else {
        tempStr += "下一页>";
        tempStr += "尾页";
    }
    var moveFocus = document.getElementById("b" + idData);
    moveFocus.innerHTML = tempStr;
    jQuery('html, body').animate({
        scrollTop: thisTop
    }, 1);
}

function addButtons(idData,tdName,obj2plus) {
    var itable = document.getElementById(idData);
    var num = itable.rows.length;//表格所有行数(所有记录数)
    var num2 = itable.rows[0].cells.length;
    var true_num = num - parseInt(num / 31) - 1;
    var tdCnt = -1;
    for (var i = 1; i < (num2 + 1); i++) {
        var icell = itable.rows[0].cells[i - 1];
        if (icell.innerHTML.indexOf(tdName) > tdCnt) {
            tdCnt = i;
            break;
        }
    }
    if (tdCnt < 0) {
        alert("错误,不能正常显示或不能提供详细信息");
        return;
    }
    for (var i1 = 2; i1 < (num + 1); i1++) {
        var irow = itable.rows[i1-1];
        var icell1 = irow.cells[tdCnt - 1];
        var reg2rep = new RegExp("{id2bind}", "g");
        var str2rep = obj2plus.replace(reg2rep, icell1.innerHTML)
        icell1.innerHTML += str2rep;
    }
}