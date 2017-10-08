<template>
  <span>
    <button id="addProjectTypeBtn" type="button" class="btn btn-md btn-kpi-default panel-heading-control"><span
      class="fa fa-plus-square static-pos"></span>&nbsp; Add Project Type
    </button>
    <div id="newProjectTypeDialog" class="modal fade kpi-dialog" role="dialog">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><i class="fa fa-close"></i></button>
            <h4 class="modal-title">Add new Project Type</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-md-12 ">
                <form class="form-horizontal">
                  <fieldset>
                    <div class="form-group" :class="{'has-error': errors.has('type.name')}" >
                      <label class="col-md-4 control-label" for="newProjectTypeDialog_projectTypenameTxt">Project
                        Type Name</label>
                      <div class="col-md-6">
                        <input id="newProjectTypeDialog_projectTypenameTxt" v-model="type.name" name="projectTypeName"
                               type="text"
                               placeholder="Project Type Name"
                               class="form-control input-md">
                        <p class="text-danger" v-if="errors.has('type.name')">{{ errors.first('type.name') }}</p>
                      </div>
                    </div>
                    <div class="form-group ">
                      <label class="col-md-4 control-label"
                             for="newProjectTypeDialog_labelBox">Label</label>
                      <div class="col-md-6">
                        <select v-model="type.label" id="newProjectTypeDialog_labelBox"
                                class="selectpicker form-control" required>
                          <option data-content="<span class='fa fa-tag kpi-label-default'>&nbsp; Default</span>">default
                          </option>
                          <option data-content="<span class='fa fa-tag kpi-label-red'>&nbsp; Red</span>">red
                          </option>
                          <option data-content="<span class='fa fa-tag kpi-label-blue'>&nbsp; Blue</span>">blue
                          </option>
                           <option data-content="<span class='fa fa-tag kpi-label-green'>&nbsp; Green</span>">green
                          </option>
                           <option data-content="<span class='fa fa-tag kpi-label-purple'>&nbsp; purple</span>">purple
                          </option>
                           <option data-content="<span class='fa fa-tag kpi-label-orange'>&nbsp; Orange</span>">orange
                          </option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="col-md-12 text-center">
                        <button id="newProjectTypeDialog_createBtn" type="button" @click.prevent="addProjectType" class="btn btn-success"><span
                          class="fa fa-save"></span>&nbsp;&nbsp;Save
                        </button>
                        &nbsp;
                        <button id="newProjectTypeDialog_clearBtn" type="button" @click="clear" class="btn btn-danger"><span
                          class="fa fa-times-circle"></span>&nbsp;&nbsp;Clear
                        </button>
                      </div>
                    </div>
                  </fieldset>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </span>
</template>
<script>

  import $ from 'jquery';

  function newType() {
    return {
      name: '',
      label: 'default',
    };
  }

  export default {
    name: 'AddProjectType',
    data() {
      return {
        type: newType(),
      };
    },
    methods: {
      addProjectType() {
        this.$validator.validateAll({ 'type.name': this.type.name }).then(() => {
          if (!this.errors.any()) {
            this.$store.dispatch('add', this.type);
            this.type = newType();
            $('#newProjectTypeDialog').modal('toggle');
          }
        });
      },
      clear() {
        this.type = newType();
      },
    },
    mounted() {
      $('#addProjectTypeBtn').click(() => {
        $('#newProjectTypeDialog').modal({
          backdrop: 'static',
          keyboard: false,
        });
        $('#newProjectTypeDialog_labelBox').prop('selectedIndex', 0);
      });
      $('.selectpicker').selectpicker();
      this.$validator.attach('type.name', 'required', { alias: 'Project Type Name' });
    },
  };
</script>

