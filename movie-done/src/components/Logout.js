import React from 'react';
import { GoogleLogout } from 'react-google-login';

const clientId =
  '14605374787-7jlakov4reqpb1fetga83fo96le5ncmk.apps.googleusercontent.com';

function Logout() {
  const onSuccess = () => {
    console.log('Logout made successfully');
    alert('Logout made successfully ✌');
  };

  return (
    <div>
      <GoogleLogout
        clientId="14605374787-cdl5frckeibn3b9ppqh1pplji5e3u92v.apps.googleusercontent.com"
        buttonText="Logout"
        onLogoutSuccess={onSuccess}
      ></GoogleLogout>
    </div>
  );
}

export default Logout;