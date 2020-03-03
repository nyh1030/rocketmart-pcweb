const CommonUtils = {

    redirectPage(targetPage) {
        location.href = targetPage;
    },
    forwardPage(targetPage) {
        location.replace(targetPage);
    },
    backwardPage() {
        history.back();
    },
    getCheckValToCommaString(objTarget) {
        let returnArray = [];
        objTarget.each(function() {
            if ($(this).prop('checked')) returnArray.push($(this).val());
        });
        return returnArray.join(",");
    },
    getDataToCommaString(objTarget) {
        const _this = this;
        let returnArray = [];
        objTarget.each(function() {
            returnArray.push(_this.removeComma($(this).val()));
        });
        return returnArray.join(",");
    },
    removeComma(targetValue) {
        return parseInt(targetValue.replace(/,/g,""));
    },
    keyEventOnlyNumber(obj, blnComma) {
        if (blnComma) obj.value = obj.value.replace(/[^0-9\.]/g,'').replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        else obj.value = obj.value.replace(/[^0-9\.]/g,'');
    }
};

Object.assign(Element.prototype, {

    domTag(elName) {
        let temp;
        const vElement = this.querySelector(elName);
        if ( !vElement ) {
            temp = document.querySelector("#undefined");
            temp.id = "undefined";
            temp.style = "width:0; hight:0";
            temp.addClass("hidden");
        }
        return !vElement ? temp : vElement;
    },

    domTags(elName) {
        const vElements = this.querySelectorAll(elName);
        return vElements ? vElements : [];
    },
});

Object.assign(String.prototype, {
    replaceAll() {
        return this;
    }
});


//modalPopup 호출
$.modalPopup = function(opt) {
    $.ajax({
        url: opt.url,
        data: opt.data,
        dataType: 'html',
        success: function(html) {
            $("<div class='modal_popup'>" + html + '</div>')
                .appendTo('body')
                .modal({
                    escapeClose: false,
                    clickClose: false,
                    closeExisting: false
                })
                // 창뜰때 애니메이션 : jackInTheBox
                .addClass('animated faster')
                .addClass(opt.animation || 'jackInTheBox')
                .on($.modal.CLOSE, function(event, modal) {
                    if (opt.close) opt.close(modal.result);

                    modal.elm.remove();
                });
        },
        error: function(res) {
            if (opt.error) opt.error(res.responseText);
            else {
                alert('error');
            }
            throw 'popup_error';
        }
    });
};