import { Component, OnInit } from "@angular/core";
import { Usuario } from "./../../../shared/models/user";
import { Router } from "@angular/router";
import { AuthService } from "./../../../shared/services/auth.service";

@Component({
  selector: "app-result",
  templateUrl: "./result.component.html",
  styleUrls: ["./result.component.scss"]
})
export class ResultComponent implements OnInit {
  userDetail: Usuario;
  constructor(
    private authService: AuthService,
    private router: Router) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() {

  }

  goSetting() {
    /*var win = new BrowserWindow({
      width: 800,
      height: 600,
      center: true,
      resizable: false,
      frame: true,
      transparent: false
    });

    win.loadURL(url.format({
      pathname: path.join(__dirname, './index.html'),
      protocol: 'file:',
      slashes: true,
      hash: 'setting'
    }));*/

    var params = `scrollbars=no,resizable=no,status=no,location=no,toolbar=no,menubar=no,
width=0,height=0,left=-1000,top=-1000`;
var winRef = window.open('http://10.39.1.99/', 'Product Category', params);
winRef.focus();
    // // Load the page + route
    // win.loadURL('file://' + __dirname + '/index.html#/setting');
    // this.router.navigateByUrl('setting');
  }
}
