const CommonUtils = {

    domTag(pName) {
    },
    forwardPage(targetPage) {
        location.replace(targetPage);
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