import {  useState } from "react";
import { useAuth } from "../../AuthProvider";

export default function Login() {
  const [userName, setUserName] = useState("");
  const [userPassword, setUserPassword] = useState("");
  const {loginUser} = useAuth();

  // Move the addUser function outside of useEffect
  // const loginUser = async (user) => {
  //   const response = await fetch("/api/users/login", {
  //     method: "POST",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify(user),
  //   });
  //   return await response.json();
  // };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const user = {
      user_name: userName,
      user_password: userPassword,
    };
    try {
      await loginUser(user);
    
    } catch (err) {
      alert("This e-mail or password is incorrect!")
    }
  };

  return (
    <form onSubmit={handleSubmit} className="login">
      <div>
        <label htmlFor="userNameLogIn">Username </label>
        <input
          id="userNameLogIn"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="userPasswordLogIn">Password </label>
        <input
          id="userPasswordLogIn"
          type="password"
          value={userPassword}
          onChange={(e) => setUserPassword(e.target.value)}
        />
      </div>
      <button type="submit">Log In</button>
    </form>
  );
}
