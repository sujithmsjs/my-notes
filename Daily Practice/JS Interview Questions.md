I tried to getAllUser if the response status is 401,403 jwt token has expired, it instead of rendering UserList page, it has to redirect to Login again page. I can't use useNavigate hook in this getAllUser method. How to overcome this problem.

export const getAllUser = async () => {

    console.info('Inside GET ALL USERS');
    const pagination = {
        active: true,
        pageSize: 10,
        pageNumber: 1,
        searchValue: "",
        export: false
    }

    // console.info('Instance: ', callAPI().defaults)   
    try {
        const res = await axiosInstance.post('/getAllUsers', pagination);
        console.info('Inside getAllUser success',res);
        return res.data.data.data;
    } catch (error) {
        console.info('Inside getAllUser error',error)
    }

    return [];
}


