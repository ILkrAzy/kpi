<template>
  <button class="btn btn-sm  user-action-btn user-action-btn-delete" :class="'user-' + user.username + '-action-btn-delete'">
    <span class="fa fa-trash"></span>
  </button>
</template>

<script>
  import $ from 'jquery';

  export default {
    name: 'deleteUserButton',
    props: ['user'],
    mounted() {
      $('.user-action-btn-delete').tooltip({ placement: 'auto bottom', title: 'Delete User' });
      const deleteUserConfirmBox = 'Are you sure to delete this user?' +
        '<div class="row"> ' +
        '<div class="col-sm-12 text-center"> ' +
        `<button id="user-${this.user.username}-delete-yes" data-toggle="clickover" class="btn btn-sm btn-success" >Yes</button> &nbsp;` +
        '<button id="user-delete-no" data-toggle="clickover" class="btn btn-sm btn-danger" >No</button>' +
        '</div></div>';
      $(`.user-${this.user.username}-action-btn-delete`).popover({
        animation: true,
        content: deleteUserConfirmBox,
        html: true,
        placement: 'auto left',
        trigger: 'focus',
      }).on('shown.bs.popover', () => {
        $(`#user-${this.user.username}-delete-yes`).click(() => {
          this.$store.dispatch('deleteUser', this.user);
          $.notify(
            `Deleted user "${this.user.username}" successfully.`,
            {
              position: 'top center',
              className: 'success',
            },
          );
        });
      });
    },
  };
</script>

