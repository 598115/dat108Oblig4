class Validation {

    #regElm;
    #fieldElm;
    #fornavnElm;
    #etternavnElm;
    #mobilElm;
    #passordElm
    #passordrepElm

    constructor(root) {
        this.#regElm = root.getElementsByTagName('form')[0];

        const submitButton = this.#regElm.getElementsByClassName('submit-button')[0];
        submitButton.addEventListener('click', (event) => {
            event.preventDefault(); 
            this.#ValidateInputs();
        });

        this.#fieldElm = this.#regElm.getElementsByTagName('fieldset')[0];     
        this.#fornavnElm = this.#fieldElm.getElementsByTagName("input")[0];
        this.#etternavnElm = this.#fieldElm.getElementsByTagName("input")[1];
        this.#mobilElm = this.#fieldElm.getElementsByTagName("input")[2];
        this.#passordElm = this.#fieldElm.getElementsByTagName("input")[3];
        this.#passordrepElm = this.#fieldElm.getElementsByTagName("input")[4];

    }

    #ValidateInputs() {

        console.log("validating...");

      const  fornavnRegx = /^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\-\s]*/;
      const etternavnRegx = /^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\-]*/;
      const  mobilRegx = /^\d{8}$/;

      if(!fornavnRegx.test(this.#fornavnElm.value)) {
        ////////error message
        this.#fornavnElm.classList.add("invalid");
        this.#fornavnElm.setCustomValidity("Fornavn er ugyldig");
        this.#fornavnElm.reportValidity();
        return;
      }
      else {
        this.#fornavnElm.classList.remove("invalid");
        this.#fornavnElm.classList.add("valid");
        this.#fornavnElm.reportValidity();
      }

      if(!etternavnRegx.test(this.#etternavnElm.value)) {
        ///////error message
        this.#etternavnElm.classList.add("invalid");
        this.#etternavnElm.setCustomValidity("Etternavn er ugyldig");
        this.#etternavnElm.reportValidity();
        return;
      }
      else {
        this.#etternavnElm.classList.remove("invalid");
        this.#etternavnElm.classList.add("valid");
        this.#etternavnElm.reportValidity();
      }

      if(!mobilRegx.test(this.#mobilElm.value)) {
        ////////error message
        this.#mobilElm.classList.add("invalid");
        this.#mobilElm.setCustomValidity("Mobilnummer må være 8 siffer");
        this.#mobilElm.reportValidity();
        return;
      }
      else {
        this.#mobilElm.classList.remove("invalid");
        this.#mobilElm.classList.add("valid");
        this.#mobilElm.reportValidity();
      }

      if(this.#passordElm.value.length < 6) {
        //////////error message
        this.#passordElm.classList.add("invalid");
        this.#passordElm.setCustomValidity("Passord må være minst 6 tegn");
        this.#passordElm.reportValidity();
        return;
      }
      else {
        this.#passordElm.classList.remove("invalid");
        this.#passordElm.classList.add("valid");
        this.#passordElm.reportValidity();
      }

      if(this.#passordElm.value !== this.#passordrepElm.value) {
        ////////error message
        this.#passordrepElm.classList.add("invalid");
        this.#passordrepElm.setCustomValidity("Passord matcher ikke");
        this.#passordrepElm.reportValidity();
        return;
      }
      else {
        this.#passordrepElm.classList.remove("invalid");
        this.#passordrepElm.classList.add("valid");
        this.#passordrepElm.reportValidity();
      }

      this.#regElm.submit();

    }
}
document.addEventListener('DOMContentLoaded', () => {
    const validation = new Validation(document);
  });